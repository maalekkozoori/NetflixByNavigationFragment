package android.example.netflixbynavigationfragment

import android.content.Context
import androidx.appcompat.app.AppCompatActivity


fun refreshFragment2(context: Context){
    context?.let {
        val fragmentManager = (context as? AppCompatActivity)?.supportFragmentManager
        fragmentManager?.let {
            val currentFragment = fragmentManager.findFragmentById(R.id.container_fragment)
            currentFragment?.let {
                val fragmentTransaction = fragmentManager.beginTransaction()
                fragmentTransaction.detach(it)
                fragmentTransaction.attach(it)
                fragmentTransaction.commit()
            }
        }
    }
}