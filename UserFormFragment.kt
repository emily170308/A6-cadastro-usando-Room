package com.example.roomfragments.ui.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.roomfragments.data.User
import com.example.roomfragments.databinding.FragmentUserFormBinding
import kotlinx.coroutines.launch

class UserFormFragment : Fragment() {

    private var _binding: FragmentUserFormBinding? = null
    private val binding get() = _binding!!

    private val viewModel: UserViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserFormBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSalvarUsuario.setOnClickListener {
            val nome = binding.inputNomeUsuario.text.toString().trim()
            val email = binding.inputEmailUsuario.text.toString().trim()

            if (nome.isNotEmpty() && email.isNotEmpty()) {
                val novoUsuario = User(name = nome, email = email)
                lifecycleScope.launch {
                    viewModel.insertUser(novoUsuario)
                    parentFragmentManager.popBackStack() // volta para a lista
                }
            } else {
                if (nome.isEmpty()) binding.inputNomeUsuario.error = "Informe o nome"
                if (email.isEmpty()) binding.inputEmailUsuario.error = "Informe o e-mail"
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
