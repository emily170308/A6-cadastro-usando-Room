package com.example.emilya6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.roomfragments.data.Product
import com.example.roomfragments.databinding.FragmentProductFormBinding
import kotlinx.coroutines.launch

class ProductFormFragment : Fragment() {

    private var _binding: FragmentProductFormBinding? = null
    private val binding get() = _binding!!

    
    private val viewModel: ProductViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductFormBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSalvarProduto.setOnClickListener {
            val nome = binding.inputNomeProduto.text.toString().trim()
            val precoTexto = binding.inputPrecoProduto.text.toString().trim()

            if (nome.isNotEmpty() && precoTexto.isNotEmpty()) {
                val preco = precoTexto.toDoubleOrNull()
                if (preco != null) {
                    val novoProduto = Product(name = nome, price = preco)
                    lifecycleScope.launch {
                        viewModel.insertProduct(novoProduto)
                        // Após salvar, volta para a lista
                        parentFragmentManager.popBackStack()
                    }
                } else {
                    binding.inputPrecoProduto.error = "Digite um valor numérico válido"
                }
            } else {
                binding.inputNomeProduto.error = "Preencha todos os campos"
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
