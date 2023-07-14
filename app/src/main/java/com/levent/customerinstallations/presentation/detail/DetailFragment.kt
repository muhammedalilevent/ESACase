package com.levent.customerinstallations.presentation.detail

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.View
import androidx.compose.ui.graphics.Color
import androidx.core.content.ContextCompat
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.levent.customerinstallations.R
import com.levent.customerinstallations.common.viewBinding
import com.levent.customerinstallations.data.model.Location
import com.levent.customerinstallations.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.fragment_detail) {
    private val binding by viewBinding(FragmentDetailBinding::bind)
    private val viewModel: DetailViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fillUserInfo(viewModel.userInvoices?.list?.get(0))
        setUIContents()

    }

    private fun fillUserInfo(userInfo: Location?) {
        with(binding) {
            txtLocation.text = userInfo?.company
            txtAddressInput.text = userInfo?.address
            txtInstallationNumber.text = userInfo?.installationNumber
            txtAccountNumber.text = userInfo?.contractAccountNumber
        }
    }

    private fun setUIContents() {
        with(binding.tilNameSurname) {
            this.editText?.toString()
            this.editText?.doOnTextChanged { inputText, _, _, _ ->
                println("45ss tc $inputText")
            }
        }

        binding.tietNameSurname.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                binding.tilNameSurname.isHelperTextEnabled = false
            }
        }
        with(binding.tilTCKN) {
            this.editText?.toString()
            this.editText?.doOnTextChanged { inputText, _, _, _ ->
                if (!inputText.isNullOrBlank()) {
                    if (isTCKNCorrect(inputText.toString())) {
                        this.helperText = "TC Kimlik Doğrulaması Başarılı"

                        this.setHelperTextColor(
                            makeColorCSL(
                                ContextCompat.getColor(
                                    context,
                                    R.color.colorVerified
                                )
                            )
                        )
                        this.boxStrokeColor = ContextCompat.getColor(
                            context,
                            R.color.colorVerified
                        )
                        this.hintTextColor = makeColorCSL(
                            ContextCompat.getColor(
                                context,
                                R.color.colorVerified
                            )
                        )
                    } else {
                        this.error = "TC Kimlik Doğrulaması Başarısız"
                    }
                } else {
                    resetTCKNInputState()
                }
            }
        }

        binding.tietTCKN.setOnFocusChangeListener { _, hasFocus ->
            binding.tilNameSurname.isHelperTextEnabled = !hasFocus
        }

        with(binding.tilEmail) {
            this.editText?.toString()
            this.editText?.doOnTextChanged { inputText, _, _, _ ->
                if (!inputText.isNullOrBlank()) {
                    if (isEmailValid(inputText.toString())) {
                        this.helperText = "Email doğrulaması başarılı"

                        this.setHelperTextColor(
                            makeColorCSL(
                                ContextCompat.getColor(
                                    context,
                                    R.color.colorVerified
                                )
                            )
                        )
                        this.boxStrokeColor = ContextCompat.getColor(
                            context,
                            R.color.colorVerified
                        )
                        this.hintTextColor = makeColorCSL(
                            ContextCompat.getColor(
                                context,
                                R.color.colorVerified
                            )
                        )
                    } else {
                        this.error = "Email doğrulaması başarısız"
                    }
                } else {
                    resetEmailInputState()
                }
            }
        }

        binding.tietEmail.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                binding.tilNameSurname.isHelperTextEnabled = false
            }
        }

        with(binding.tilPhoneNumber) {
            this.editText?.toString()
            this.editText?.doOnTextChanged { inputText, _, _, _ ->
                if (!inputText.isNullOrBlank()) {
                    if (isPhoneValid(inputText.toString())) {
                        this.helperText = "Telefon Numarası Doğrulaması başarılı"

                        this.setHelperTextColor(
                            makeColorCSL(
                                ContextCompat.getColor(
                                    context,
                                    R.color.colorVerified
                                )
                            )
                        )
                        this.boxStrokeColor = ContextCompat.getColor(
                            context,
                            R.color.colorVerified
                        )
                        this.hintTextColor = makeColorCSL(
                            ContextCompat.getColor(
                                context,
                                R.color.colorVerified
                            )
                        )
                    } else {
                        this.error = "Telefon Numarası Doğrulaması başarısız"
                    }
                } else {
                    resetPhoneInputState()
                }
            }
        }

        binding.tietPhoneNumber.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                binding.tilNameSurname.isHelperTextEnabled = false
            }
        }

    }

    private fun resetTCKNInputState() {
        with(binding.tilTCKN) {
            this.hintTextColor = makeColorCSL(
                ContextCompat.getColor(
                    context,
                    R.color.colorPrimary
                )
            )
            this.boxStrokeColor = ContextCompat.getColor(
                context,
                R.color.colorPrimary
            )
            this.setHelperTextColor(
                makeColorCSL(
                    ContextCompat.getColor(
                        context,
                        com.google.android.material.R.color.mtrl_indicator_text_color
                    )
                )
            )
            this.helperText = getString(R.string.helperTextTCKN)
        }
    }

    private fun resetPhoneInputState() {
        with(binding.tilPhoneNumber) {
            this.hintTextColor = makeColorCSL(
                ContextCompat.getColor(
                    context,
                    R.color.colorPrimary
                )
            )
            this.boxStrokeColor = ContextCompat.getColor(
                context,
                R.color.colorPrimary
            )
            this.setHelperTextColor(
                makeColorCSL(
                    ContextCompat.getColor(
                        context,
                        com.google.android.material.R.color.mtrl_indicator_text_color
                    )
                )
            )
            this.helperText = getString(R.string.helperTextPhone)
        }
    }

    private fun resetEmailInputState() {
        with(binding.tilEmail) {
            this.hintTextColor = makeColorCSL(
                ContextCompat.getColor(
                    context,
                    R.color.colorPrimary
                )
            )
            this.boxStrokeColor = ContextCompat.getColor(
                context,
                R.color.colorPrimary
            )
            this.setHelperTextColor(
                makeColorCSL(
                    ContextCompat.getColor(
                        context,
                        com.google.android.material.R.color.mtrl_indicator_text_color
                    )
                )
            )
            this.helperText = getString(R.string.helperTextEmail)
        }
    }

    private fun makeColorCSL(colorHashCode: Int): ColorStateList {
        return ColorStateList.valueOf(colorHashCode)
    }

    fun isEmailValid(email: String): Boolean {
        val EMAIL_REGEX = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})";
        return EMAIL_REGEX.toRegex().matches(email);
    }

    fun isPhoneValid(phone: String): Boolean {
        val PHONE_REGEX =
            "^\\+?\\(?[0-9]{1,3}\\)? ?-?[0-9]{1,3} ?-?[0-9]{3,5} ?-?[0-9]{4}( ?-?[0-9]{3})?"
        return PHONE_REGEX.toRegex().matches("90$phone")
    }

    private fun isTCKNCorrect(id: String?): Boolean {
        if (id == null) return false
        if (id.length != 11) return false
        val chars = id.toCharArray()
        val a = IntArray(11)
        for (i in 0..10) {
            a[i] = chars[i].code - '0'.code
        }
        if (a[0] == 0) return false
        if (a[10] % 2 == 1) return false
        if (((a[0] + a[2] + a[4] + a[6] + a[8]) * 7 - (a[1] + a[3] + a[5] + a[7])) % 10 != a[9]) return false
        return (a[0] + a[1] + a[2] + a[3] + a[4] + a[5] + a[6] + a[7] + a[8] + a[9]) % 10 == a[10]
    }
}


