package hu.mateboldi.mienkavilag

import android.content.ContentValues
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayout

private const val TAG="HELY"

class terkepAdapter(val context: Context, val felhasz: List<felhasz>, val onClickListener: OnClickListener):RecyclerView.Adapter<terkepAdapter.ViewHolder>() {

    interface OnClickListener{
        fun onItemClick(position: Int)
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(
            android.R.layout.simple_list_item_1,
            parent,
            false
        )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val felhasz=felhasz[position]
        //ellenőrizni, hogy jól működik e az értékadás
        holder.itemView.setOnClickListener{
            //Log.i(TAG, "pozi: "+position)
            Log.i(TAG, "pozicíó: $position")
            onClickListener.onItemClick(position)
        }

        val textViewTitle=holder.itemView.findViewById<TextView>(android.R.id.text1)//simple_list_item_1 ben ez a neve (ami fent van a 17. sorban)


        textViewTitle.text=felhasz.varos

    }

    override fun getItemCount()= felhasz.size

}