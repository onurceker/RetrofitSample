package com.example.retrofitsample

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.retrofitsample.api.ApiService
import com.example.retrofitsample.api.RetrofitApi
import com.example.retrofitsample.data.ResponseMessage
import com.example.retrofitsample.data.User
import com.example.retrofitsample.data.UserResponse
import com.example.retrofitsample.databinding.FragmentFirstBinding
import retrofit2.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var service: ApiService

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        service = RetrofitApi.getInstance().create(ApiService::class.java)


        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            service.getUsers().enqueue(object : Callback<UserResponse>{
                override fun onResponse(
                    call: Call<UserResponse>,
                    response: Response<UserResponse>
                ) {
                    Log.i("Users", response.body().toString())
                }

                override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                    Log.i("Error", t.message.toString())
                }
            })
        }

        binding.buttonSecond.setOnClickListener {
            service.getUserById("2").enqueue(object : Callback<User>{
                override fun onResponse(
                    call: Call<User>,
                    response: Response<User>
                ) {
                    Log.i("Users", response.body().toString())
                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    Log.i("Error", t.message.toString())
                }
            })
        }

        binding.buttonThird.setOnClickListener {
            service.getUserBy("2").enqueue(object : Callback<User>{
                override fun onResponse(
                    call: Call<User>,
                    response: Response<User>
                ) {
                    Log.i("Users", response.body().toString())
                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    Log.i("Error", t.message.toString())
                }
            })
        }

        binding.buttonCreate.setOnClickListener {
            val user = User(id = 3, name = "Tunahan", surname = "Bozkurt", birthday = "12/12/1990", image = "https://www.shutterstock.com/image-photo/head-shot-portrait-close-smiling-260nw-1714666150.jpg\"\n")

            service.createUser(user).enqueue(object : Callback<ResponseMessage>{
                override fun onResponse(
                    call: Call<ResponseMessage>,
                    response: Response<ResponseMessage>
                ) {
                    Log.i("createUser", response.body().toString())
                }

                override fun onFailure(call: Call<ResponseMessage>, t: Throwable) {
                    Log.i("Error", t.message.toString())
                }
            })
        }

        binding.buttonDelete.setOnClickListener {
            service.deleteUser().enqueue(object : Callback<ResponseMessage>{
                override fun onResponse(
                    call: Call<ResponseMessage>,
                    response: Response<ResponseMessage>
                ) {
                    Log.i("deleteUser", response.body().toString())
                }

                override fun onFailure(call: Call<ResponseMessage>, t: Throwable) {
                    Log.i("Error", t.message.toString())
                }
            })
        }


        binding.buttonHeader.setOnClickListener {
            service.getUsersWithHeader("qwerty").enqueue(object : Callback<UserResponse>{
                override fun onResponse(
                    call: Call<UserResponse>,
                    response: Response<UserResponse>
                ) {
                    Log.i("getUsersWithHeader", response.body().toString())
                }

                override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                    Log.i("Error", t.message.toString())
                }
            })
        }

        binding.buttonHeaders.setOnClickListener {
            service.getUsersWithHeaders(mutableMapOf(Pair("token", "qwerty"))).enqueue(object : Callback<UserResponse>{
                override fun onResponse(
                    call: Call<UserResponse>,
                    response: Response<UserResponse>
                ) {
                    Log.i("getUsersWithHeader", response.body().toString())
                }

                override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                    Log.i("Error", t.message.toString())
                }
            })
        }

        binding.buttonGetWithUrl.setOnClickListener {
            service.getUsersWithUrl("https://www.google.com/users").enqueue(object : Callback<UserResponse>{
                override fun onResponse(
                    call: Call<UserResponse>,
                    response: Response<UserResponse>
                ) {
                    Log.i("getUsersWithHeader", response.body().toString())
                }

                override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                    Log.i("Error", t.message.toString())
                }
            })
        }

        binding.buttonUpdateUser.setOnClickListener {
            service.updateUser("Onur", "Çeker").enqueue(object : Callback<User>{
                override fun onResponse(
                    call: Call<User>,
                    response: Response<User>
                ) {
                    Log.i("getUsersWithHeader", response.body().toString())
                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    Log.i("Error", t.message.toString())
                }
            })
        }

        binding.buttonGlide.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}