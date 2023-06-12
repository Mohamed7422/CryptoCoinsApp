package com.example.cryptoapp.data.network.dto

import com.example.cryptoapp.domain.model.CoinInfo
import com.google.gson.annotations.SerializedName

data class CoinInfoDto(
    val description: String,
    val development_status: String,
    val first_data_at: String,
    val hardware_wallet: Boolean,
    val hash_algorithm: String,
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    @SerializedName("last_data_at")
    val lastDataAt: String,
    val links: Links,
    val links_extended: List<LinksExtended>,
    val logo: String,
    val message: String,
    val name: String,
    @SerializedName("open_source")
    val openSource: Boolean,
    @SerializedName("org_structure")
    val orgStructure: String,
    @SerializedName("proof_type")
    val proofType: String,
    val rank: Int,
    @SerializedName("started_at")
    val startedAt: String,
    val symbol: String,
    val tags: List<Tag>,
    val team: List<TeamMember>,
    val type: String,
    val whitepaper: Whitepaper
)

fun CoinInfoDto.toCoinInfo():CoinInfo{
    return CoinInfo(
        coinId = id,
        name = name,
        description= description,
        symbol = symbol,
        rank = rank,
        isActive = isActive,
        tags = tags.map { it.name },
        team = team
    )
}