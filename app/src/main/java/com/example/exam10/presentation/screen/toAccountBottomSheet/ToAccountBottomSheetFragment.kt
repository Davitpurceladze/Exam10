package com.example.exam10.presentation.screen.toAccountBottomSheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.exam10.databinding.FragmentToAccountBottomSheetBinding
import com.example.exam10.presentation.model.account.Account
import com.example.exam10.presentation.screen.home.HomeFragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ToAccountBottomSheetFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentToAccountBottomSheetBinding

    private var clickListener: ToAccountBottomSheetClickListener? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentToAccountBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
        bindObserves()

    }

    fun setToAccountBottomSheetClickListener(listener: ToAccountBottomSheetClickListener) {
        this.clickListener = listener
    }

    private fun sentAccountCredentials(account: Account) {
        clickListener?.chooseAccount(account)
        dismiss()
    }

    private fun bind() {

        with(binding) {
            fun closeButtons() {
                tvByAccountNumber.visibility = View.GONE
                tvByPersonalNumber.visibility = View.GONE
                tvByPhoneNumber.visibility = View.GONE
            }
            fun openSubmitButton() {
                btnSubmit.visibility = View.VISIBLE
            }

            tvByAccountNumber.setOnClickListener {
                etByAccountNumber.visibility = View.VISIBLE
                closeButtons()
                openSubmitButton()
            }

            tvByPersonalNumber.setOnClickListener {
                etByPersonalNumber.visibility = View.VISIBLE
                closeButtons()
                openSubmitButton()
            }

            tvByPhoneNumber.setOnClickListener {
                etByPhoneNumber.visibility = View.VISIBLE
                closeButtons()
                openSubmitButton()
            }
        }

    }
    private fun bindObserves() {}

}