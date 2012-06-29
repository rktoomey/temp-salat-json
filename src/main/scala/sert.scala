/*
Model classes for the SERT data
*/


case class UnitNumber(
  value: Float,
  units: String
  )

case class SertCountry(
  id: String,
  name: String,
  years: List[SertYear]
  )

case class SertYear(
  id: String,
  year: Int,
  data: SertData
  )

case class SertData(
  //coal: SertCoal
  )

case class SertCoal2(
  bituminous: UnitNumber,
  lignite: UnitNumber)

case class SertCoal(
  production: SertCoal2,
  provedRecoverableReserves: SertCoal2
  )

case class SertCrudeOilGas(
  production: UnitNumber,
  productionBarrels: UnitNumber,
  productionRPRatio: UnitNumber,
  provedRecoverableReserves: UnitNumber,
  provedRecoverableReservesBarrels: UnitNumber
  )

case class SertHydropower(
  capabilityGrossTheoretical: UnitNumber,
  capabilityEconomicallyExploitable: UnitNumber,
  capabilityTechnicallyExploitable: UnitNumber,
  inOperation: UnitNumber,
  actualGeneration: UnitNumber,
  underConstructionCapacity: UnitNumber,
  plannedCapacity: UnitNumber
  )

case class SertNaturalGas(
  productionGross: UnitNumber,
  productionShrinkage: UnitNumber,
  productionNet: UnitNumber,
  productionNetImperial: UnitNumber,
  productionRPRatio: UnitNumber,
  provedRecoverableReserves: UnitNumber,
  provedRecoverableReservesImperial: UnitNumber
  )

case class SertOilShale(
  shale: UnitNumber,
  barrels: UnitNumber
  )

case class SertUranium(
  inferredResources: SertUranium3,
  production: UnitNumber,
  productionCumulative: UnitNumber,
  reasonablyAssuredResources: SertUranium3,
  undiscoveredResources: SertUranium3,
  undiscoveredResourcesSpeculativeCost: UnitNumber,
  undiscoveredResourcesTotal: UnitNumber
  )

case class SertUranium3(
  u80: UnitNumber,
  u130: UnitNumber,
  u260: UnitNumber
  )


/*

Coal_Production_Bituminous_million_tonnes="0.1" 
Coal_Production_Lignite_million_tonnes="3" 
Coal_Proved_Recoverable_Reserves_Bituminous_million_tonnes="47" 
Coal_Proved_Recoverable_Reserves_Lignite_million_tonnes="1853" 

Crude_Oil_Gas_Production_million_tonnes="4.8" 
Crude_Oil_Gas_Production_thousand_barrels_per_day="111"
Crude_Oil_Gas_Production_RP_ratio="14.6" 
Crude_Oil_Gas_Proved_Recoverable_Reserves_million_tonnes="70" 
Crude_Oil_Gas_Proved_Recoverable_Reserves_million_barrels="594" 

Hydropower_Capability_Gross_theoretical_TWhyr="88" 
Hydropower_Capability_Economically_exploitable_TWhyr="15" 
Hydropower_Capability_Technically_exploitable_TWhyr="27" 
Hydropower_Status_Development_Inoperation_MW="1710" 
Hydropower_Status_Development_Actualgeneration_GWh="6396" 
Hydropower_Status_Development_Underconstruction_Capacity_MW="341" 
Hydropower_Status_Development_PlannedCapacity_MW="1762" 

Natural_Gas_Production_billion_cubic_metres_Gross="63.7" 
Natural_Gas_Production_billion_cubic_metres_Shrinkage="0.3" 
Natural_Gas_Production_billion_cubic_metres_Net="63.4" 
Natural_Gas_Production_billion_cubic_feet_Net="2239" 
Natural_Gas_Production_RP_ratio="27.39403454" 
Natural_Gas_Proved_Recoverable_billion_cubic_metres="1745" 
Natural_Gas_Proved_Recoverable_billion_cubic_feet="61625" 

NB_Deposits_number="8" 
EHO_Deposits_number="1" 

Oil_Shale_million_barrels="8386" 
Oil_Shale_million_tonnes="1200" 

Uranium_Inferred_Resources_US80kgU="31" 
Uranium_Inferred_Resources_US130kgU="38.6" 
Uranium_Inferred_Resources_US260kgU="38.6" 
Uranium_Production_Production_tonnes="2340" 
Uranium_Production_Cumulative_tonnes="34939" 
Uranium_reasonably_assured_resources_US80kgU="55.2" 
Uranium_reasonably_assured_resources_US130kgU="76" 
Uranium_reasonably_assured_resources_US260kgU="76" 
Uranium_undiscovered_resources_Prognosticated_US80kgU="56.3" 
Uranium_undiscovered_resources_Prognosticated_US130kgU="84.969" 
Uranium_undiscovered_resources_Prognosticated_US260kgU="85" 
Uranium_undiscovered_resources_Speculative_Cost_thousand_tonnes="134.7" 
Uranium_undiscovered_resources_Total_Prognosticated_thousand_tonnes="219.7"

*/