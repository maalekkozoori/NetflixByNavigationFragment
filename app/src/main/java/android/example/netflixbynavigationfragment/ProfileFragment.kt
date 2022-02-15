package android.example.netflixbynavigationfragment

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.example.netflixbynavigationfragment.databinding.FragmentProfileBinding
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.text.Editable
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    lateinit var binding: FragmentProfileBinding
    lateinit var sharedPreferences: SharedPreferences
    val sharedViewModel: MoviesDataBase by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProfileBinding.bind(view)

        sharedPreferences =
            requireContext().getSharedPreferences("RegisterInfo", Context.MODE_PRIVATE)

        var getImageFromCamera =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    cameraImage(result.data)
                }
            }

        var getImageFromGallery = registerForActivityResult(ActivityResultContracts.GetContent(),
            ActivityResultCallback {
                binding.imgProfile.setImageURI(it)
            })

        binding.btnCamera.setOnClickListener {
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            getImageFromCamera.launch(cameraIntent)
        }

        binding.btnGallery.setOnClickListener {
            getImageFromGallery.launch("image/*")
        }

        binding.btnEditProfile.setOnClickListener {
            with(binding){
                if (btnCamera.isVisible) {
                    btnCamera.isVisible = false
                    btnGallery.isVisible = false
                    tvUsarename.isEnabled = false
                    btnEditProfile.text = "Edit Profile"
                    saveChanges()
                } else {
                    btnCamera.isVisible = true
                    btnGallery.isVisible = true
                    tvUsarename.isEnabled = true
                    btnEditProfile.text = "Save Changes"
                }
            }
        }


        binding.btnLogout.setOnClickListener {
            with(binding){
                if (sharedViewModel.registerStatus){
                    sharedPreferences.edit().clear().apply()
                    val clean: Editable?  = null
                    tvUsarename.text = clean
                    //imgProfile.isVisible = false
                }else{
                    btnEditProfile.isVisible = false
                    tvUsarename.isVisible = false
                    btnLogout.text = "Sign In"
                    sharedViewModel.registerStatus = false
                    edUserName.isVisible = true
                    edPass.isVisible = true
                    imgProfile.isVisible = false

                }
            }


        }


    }

    private fun cameraImage(intent: Intent?) {
        val bitmap = intent?.extras?.get("data") as Bitmap
        binding.imgProfile.setImageBitmap(bitmap)
    }

    fun saveChanges() {
        with(binding) {
            var edit = sharedPreferences.edit()
            edit.putString("username", tvUsarename.text.toString())
            edit.apply()
            Toast.makeText(requireContext(), "Data Saved Successful", Toast.LENGTH_SHORT).show()
        }
    }

}