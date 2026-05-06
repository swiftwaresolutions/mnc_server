package com.ueniweb.swiftwaresolutions.services;

import com.ueniweb.swiftwaresolutions.data.*;

import java.util.List;

public interface ProductDetailsReadPlatformService {
    List<MedicineNameData> fetchMedicineNames(String medName,Integer storeId);

    List<CaseSheetTemplateData> fetchCaseSheetTemplates(Integer casesheetType,Integer templateFieldId,Long docId);

    List<StoreWiseAvailableStockData> fetchStoreWiseAvailableStock(Integer prodsId);

    List<ProdsUnitData> fetchMedicineUnitsById(Integer prodsId);

    List<EqualantDrugsData> fetchEqualentDrugsByGenericId(Integer genericId);

}
