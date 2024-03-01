package com.example.exam10.presentation.screen.fromAccountBottomSheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exam10.databinding.FragmentFromAccountBottomSheetBinding
import com.example.exam10.presentation.event.from_account.FromAccountEvent
import com.example.exam10.presentation.model.account.Account
import com.example.exam10.presentation.state.from_account.FromAccountBottomSheetState
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class FromAccountBottomSheetFragment : BottomSheetDialogFragment()   {

    private lateinit var binding: FragmentFromAccountBottomSheetBinding

    private var clickListener: FromAccountBottomSheetClickListener? = null
    private val viewModel: FromAccountBottomSheetFragmentViewModel by viewModels()
    private lateinit var fromAccountBottomSheetRecyclerAdapter: FromAccountBottomSheetRecyclerAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFromAccountBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    fun setFromAccountBottomSheetClickListener(listener: FromAccountBottomSheetClickListener) {
        this.clickListener = listener
    }


    private fun sentAccountCredentials(account: Account) {
        clickListener?.chooseAccount(account)
        dismiss()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
        bindObserves()
    }

    private fun bind() {
        viewModel.onEvent(FromAccountEvent.FetchAccount)
    }

    private fun bindObserves() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                 viewModel.fromAccountBottomSheetState.collect{
                     handleState(it)
                 }
            }
        }
    }

    private fun handleState(state: FromAccountBottomSheetState) {

        binding.progressBarInclude.progressBar.visibility =
            if(state.isLoading) View.VISIBLE else View.GONE

        state.account?.let {
            setAccountRecycler(it)
        }
    }

    private fun setAccountRecycler(accounts: List<Account>) {
        fromAccountBottomSheetRecyclerAdapter = FromAccountBottomSheetRecyclerAdapter()
        with(binding.recyclerView) {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = fromAccountBottomSheetRecyclerAdapter

        }
        fromAccountBottomSheetRecyclerAdapter.submitList(accounts)

        fromAccountBottomSheetRecyclerAdapter.setOnItemClickListener {
            val selectedAccountId = it
            val selectedAccount = accounts.filter {
                it.id == selectedAccountId
            }
            sentAccountCredentials(selectedAccount[0])
        }
    }

}