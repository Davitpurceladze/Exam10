package com.example.exam10.presentation.screen.fromAccountBottomSheet

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.exam10.databinding.ItemFragmentFromAccountBottomSheetLayoutBinding
import com.example.exam10.presentation.model.account.Account

class FromAccountBottomSheetRecyclerAdapter : ListAdapter<Account, FromAccountBottomSheetRecyclerAdapter.AccountViewHolder>(AccountDiffUtil()) {

    private var onItemClickListener: ((id: Int) -> Unit)? = null

    fun setOnItemClickListener(listener: (id: Int) -> Unit)  {
        onItemClickListener = listener
    }

    inner class AccountViewHolder(private val binding: ItemFragmentFromAccountBottomSheetLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private lateinit var item: Account
        fun bind() {
            item = currentList[adapterPosition]
             with(binding) {
                    tvCardType.text = item.cardType
                    tvMoney.text = item.balance.toString()
                    tvCardNumber.text =item.accountNumber
                 tvValuteType.text = item.valuteType.toString()
                 root.setOnClickListener {
                     onItemClickListener?.invoke(item.id)
                 }
             }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = AccountViewHolder(
        ItemFragmentFromAccountBottomSheetLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: AccountViewHolder, position: Int) {
        holder.bind()
    }

    class AccountDiffUtil : DiffUtil.ItemCallback<Account>() {
        override fun areItemsTheSame(oldItem: Account, newItem: Account): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Account, newItem: Account): Boolean {
            return oldItem == newItem
        }
    }
}