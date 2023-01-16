package ru.netology.markers.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.netology.markers.R
import ru.netology.markers.databinding.FragmentNewPointBinding
import ru.netology.markers.dto.PointMap
import ru.netology.markers.utils.Companion.Companion.idPoint
import ru.netology.markers.utils.Companion.Companion.latitude
import ru.netology.markers.utils.Companion.Companion.longitude
import ru.netology.markers.viewmodel.PointViewModel

@AndroidEntryPoint
class FragmentNewPoint : Fragment() {
    private lateinit var binding: FragmentNewPointBinding
    private val viewModel: PointViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewPointBinding.inflate(layoutInflater)
        val coordinate = "${arguments?.latitude}; ${arguments?.longitude}"
        binding.coordinate.text = coordinate
        binding.sendPoint.setOnClickListener {
            if (!binding.inputEditTitle.text.isNullOrEmpty()) {
                arguments?.idPoint?.let {
                    with(requireArguments()) {
                        viewModel.savePoint(
                            PointMap(
                                idPoint, latitude, longitude,
                                binding.inputEditTitle.text.toString(),
                                binding.inputEditDescription.text.toString()
                            )
                        )

                    }
                }
                findNavController().navigate(R.id.action_fragmentNewPoint_to_pointsCrudFragment)
            }
        }
        return binding.root
    }
}