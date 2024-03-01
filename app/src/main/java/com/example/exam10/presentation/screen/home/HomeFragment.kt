package com.example.exam10.presentation.screen.home

import androidx.fragment.app.viewModels
import com.example.exam10.databinding.FragmentHomeBinding
import com.example.exam10.presentation.base.BaseFragment
import com.example.exam10.presentation.screen.fromAccountBottomSheet.FromAccountBottomSheetClickListener
import com.example.exam10.presentation.screen.fromAccountBottomSheet.FromAccountBottomSheetFragment
import com.example.exam10.presentation.screen.toAccountBottomSheet.ToAccountBottomSheetFragment
import com.example.exam10.presentation.state.home.HomeState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate), FromAccountBottomSheetClickListener {

    private val viewModel: HomeFragmentViewModel by viewModels()
    private lateinit var fromAccountBottomSheetFragment: FromAccountBottomSheetFragment
    private lateinit var toAccountBottomSheetFragment: ToAccountBottomSheetFragment

    override fun bind() {
//        viewModel.onEvent(HomeEvent.FetchAccount)
    }

    override fun bindViewActionListeners() {
        binding.fromAccountContainer.setOnClickListener {
            fromAccountBottomSheetFragment = FromAccountBottomSheetFragment()
            fromAccountBottomSheetFragment.setFromAccountBottomSheetClickListener(this)
            fromAccountBottomSheetFragment.show(parentFragmentManager, "fromAccountDialogFragment")
        }

        binding.toAccountContainer.setOnClickListener {
            toAccountBottomSheetFragment =ToAccountBottomSheetFragment()
//            toAccountBottomSheetFragment.setToAccountBottomSheetClickListener(this)
            toAccountBottomSheetFragment.show(parentFragmentManager, "toAccountDialogFragment")
        }
    }

    override fun bindObserves() {
//        viewLifecycleOwner.lifecycleScope.launch {
//            repeatOnLifecycle(Lifecycle.State.STARTED){
//                viewModel.homeState.collect{
//                    handleHomeState(it)
//                }
//            }
//        }
    }

    override fun chooseAccount(account: com.example.exam10.presentation.model.account.Account) {
        println("this is home fragment-> $account")
        with(binding){
             tvMoney.text = account.balance.toString()
            tvCardNumber.text = account.accountNumber.takeLast(4)
            tvValuteType.text = account.valuteType.toString()
        }

    }

    private fun handleHomeState(state: HomeState) {

//        binding.progressBarrInclude.progressBar.visibility =
//            if (state.isLoading) View.VISIBLE else View.GONE

        state.account?.let {
//            println(it)
        }

    }
}