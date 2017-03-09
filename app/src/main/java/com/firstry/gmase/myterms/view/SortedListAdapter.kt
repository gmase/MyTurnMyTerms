package com.firstry.gmase.myterms.view

import android.content.Context
import android.support.v7.util.SortedList
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import java.util.ArrayList
import java.util.Collections
import java.util.Comparator

/**
 * Created by Guille2 on 09/03/2017
 * Have fun
 */

abstract class SortedListAdapter<T : SortedListAdapter.ViewModel>(context: Context, itemClass: Class<T>, private val mComparator: Comparator<T>) : RecyclerView.Adapter<SortedListAdapter.ViewHolder<out T>>() {

    interface Editor<T : ViewModel> {
        fun add(item: T): Editor<T>
        fun add(items: List<T>): Editor<T>
        fun remove(item: T): Editor<T>
        fun remove(items: List<T>): Editor<T>
        fun replaceAll(items: List<T>): Editor<T>
        fun removeAll(): Editor<T>
        fun commit()
    }

    interface Filter<T> {
        fun test(item: T): Boolean
    }

    private val mInflater: LayoutInflater
    private val mSortedList: SortedList<T>

    init {
        mInflater = LayoutInflater.from(context)

        mSortedList = SortedList(itemClass, object : SortedList.Callback<T>() {
            override fun compare(a: T, b: T): Int {
                return mComparator.compare(a, b)
            }

            override fun onInserted(position: Int, count: Int) {
                notifyItemRangeInserted(position, count)
            }

            override fun onRemoved(position: Int, count: Int) {
                notifyItemRangeRemoved(position, count)
            }

            override fun onMoved(fromPosition: Int, toPosition: Int) {
                notifyItemMoved(fromPosition, toPosition)
            }

            override fun onChanged(position: Int, count: Int) {
                notifyItemRangeChanged(position, count)
            }

            override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
                return this@SortedListAdapter.areItemContentsTheSame(oldItem, newItem)
            }

            override fun areItemsTheSame(item1: T, item2: T): Boolean {
                return this@SortedListAdapter.areItemsTheSame(item1, item2)
            }
        })
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<out T> {
        return onCreateViewHolder(mInflater, parent, viewType)
    }

    protected abstract fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup, viewType: Int): ViewHolder<out T>

    protected abstract fun areItemsTheSame(item1: T, item2: T): Boolean
    protected abstract fun areItemContentsTheSame(oldItem: T, newItem: T): Boolean

    override fun onBindViewHolder(holder: ViewHolder<out T>, position: Int) {
        val item = mSortedList.get(position)
        (holder as ViewHolder<T>).bind(item)
    }

    fun edit(): Editor<T> {
        return EditorImpl()
    }

    fun getItem(position: Int): T {
        return mSortedList.get(position)
    }

    override fun getItemCount(): Int {
        return mSortedList.size()
    }

    fun filter(filter: Filter<T>): List<T> {
        val list = ArrayList<T>()
        var i = 0
        val count = mSortedList.size()
        while (i < count) {
            val item = mSortedList.get(i)
            if (filter.test(item)) {
                list.add(item)
            }
            i++
        }
        return list
    }

    fun filterOne(filter: Filter<T>): T? {
        var i = 0
        val count = mSortedList.size()
        while (i < count) {
            val item = mSortedList.get(i)
            if (filter.test(item)) {
                return item
            }
            i++
        }
        return null
    }

    private interface Action<T : ViewModel> {
        fun perform(list: SortedList<T>)
    }

    private inner class EditorImpl : Editor<T> {

        private val mActions = ArrayList<Action<T>>()

        override fun add(item: T): Editor<T> {
            mActions.add(object : Action<T> {
                override fun perform(list: SortedList<T>) {
                    mSortedList.add(item)
                }
            })
            return this
        }

        override fun add(items: List<T>): Editor<T> {
            mActions.add(object : Action<T> {
                override fun perform(list: SortedList<T>) {
                    Collections.sort(items, mComparator)
                    mSortedList.addAll(items)
                }
            })
            return this
        }

        override fun remove(item: T): Editor<T> {
            mActions.add(object : Action<T> {
                override fun perform(list: SortedList<T>) {
                    mSortedList.remove(item)
                }
            })
            return this
        }

        override fun remove(items: List<T>): Editor<T> {
            mActions.add(object : Action<T> {
                override fun perform(list: SortedList<T>) {
                    for (item in items) {
                        mSortedList.remove(item)
                    }
                }
            })
            return this
        }

        override fun replaceAll(items: List<T>): Editor<T> {
            mActions.add(object : Action<T> {
                override fun perform(list: SortedList<T>) {
                    val itemsToRemove = filter(object : Filter<T> {
                        override fun test(item: T): Boolean {
                            return !items.contains(item)
                        }
                    })
                    for (i in itemsToRemove.indices.reversed()) {
                        val item = itemsToRemove[i]
                        mSortedList.remove(item)
                    }
                    mSortedList.addAll(items)
                }
            })
            return this
        }

        override fun removeAll(): Editor<T> {
            mActions.add(object : Action<T> {
                override fun perform(list: SortedList<T>) {
                    mSortedList.clear()
                }
            })
            return this
        }

        override fun commit() {
            mSortedList.beginBatchedUpdates()
            for (action in mActions) {
                action.perform(mSortedList)
            }
            mSortedList.endBatchedUpdates()
            mActions.clear()
        }
    }

    abstract class ViewHolder<T : ViewModel>(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var currentItem: T? = null
            private set

        fun bind(item: T) {
            currentItem = item
            performBind(item)
        }

        protected abstract fun performBind(item: T)
    }

    interface ViewModel
}