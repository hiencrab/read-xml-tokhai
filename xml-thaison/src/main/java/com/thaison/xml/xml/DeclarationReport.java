package com.thaison.xml.xml;

import java.time.LocalDateTime;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.Getter;
import lombok.Setter;
import com.thaison.xml.util.StringDateXMLAdapter;

@Getter
@Setter
@XmlRootElement(name = "Declaration")
@XmlAccessorType(XmlAccessType.FIELD)
public class DeclarationReport {

	@XmlElementWrapper(name = "GoodItems")
	@XmlElement(name = "GoodItem")
	private List<GoodItemReport> goodItems;

	@XmlElement(name = "DeclarationNo")
	private String declarationNo;

	@XmlElement(name = "ClassificationOfOutputting")
	private String classificationOfOutputting;

	@XmlElement(name = "FirstDeclarationNo")
	private String firstDeclarationNo;

	@XmlElement(name = "BranchNumberOfDividedDeclaration")
	private String branchNumberOfDividedDeclaration;

	@XmlElement(name = "NumberOfDivisionsOfDividedDeclaration")
	private String numberOfDivisionsOfDividedDeclaration;

	@XmlElement(name = "DeclarationNumberOfTentative")
	private String declarationNumberOfTentative;

	@XmlElement(name = "AppName")
	private String appName;

	@XmlElement(name = "InspectionKindClassification")
	private String inspectionKindClassification;

	@XmlElement(name = "DeclarationStatus")
	private String declarationStatus;

	@XmlElement(name = "DeclarationVersion")
	private String declarationVersion;

	@XmlElement(name = "DeclarationKindCode")
	private String declarationKindCode;

	@XmlElement(name = "CargoClassificationCode")
	private String cargoClassificationCode;

	@XmlElement(name = "MeansOfTransportation")
	private String meansOfTransportation;

	@XmlElement(name = "RepresentativeTaxCode")
	private String representativeTaxCode;

	@XmlElement(name = "CustomsOfficeCode")
	private String customsOfficeCode;

	@XmlElement(name = "CustomsOfficeName")
	private String customsOfficeName;

	@XmlElement(name = "CustomsSubSection")
	private String customsSubSection;

	@XmlElement(name = "RegisteredDate")
	private String registeredDate;

	@XmlElement(name = "RegisteredTime")
	private String registeredTime;

	@XmlElement(name = "RegisteredDateOfCorrection")
	private String registeredDateOfCorrection;

	@XmlElement(name = "RegisteredTimeOfCorrection")
	private String registeredTimeOfCorrection;

	@XmlElement(name = "TimeLimitOfReImport")
	private String timeLimitOfReImport;

	@XmlElement(name = "SignOfTimeLimitOver")
	private String signOfTimeLimitOver;

	@XmlElement(name = "ExporterCode")
	private String exporterCode;

	@XmlElement(name = "ExporterName")
	private String exporterName;

	@XmlElement(name = "PostCode")
	private String postCode;

	@XmlElement(name = "AddressOfExporter")
	private String addressOfExporter;

	@XmlElement(name = "TelephoneNumber")
	private String telephoneNumber;

	@XmlElement(name = "ExporterContractorCode")
	private String exporterContractorCode;

	@XmlElement(name = "ExporterContractorName")
	private String exporterContractorName;

	@XmlElement(name = "ConsigneeCode")
	private String consigneeCode;

	@XmlElement(name = "ConsigneeName")
	private String consigneeName;

	@XmlElement(name = "PostCodeIdentification")
	private String postCodeIdentification;

	@XmlElement(name = "Address1")
	private String address1;

	@XmlElement(name = "Address2")
	private String address2;

	@XmlElement(name = "Address3")
	private String address3;

	@XmlElement(name = "Address4")
	private String address4;

	@XmlElement(name = "CountryCode")
	private String countryCode;

	@XmlElement(name = "PlannedDeclarantCode")
	private String plannedDeclarantCode;

	@XmlElement(name = "AgentName")
	private String agentName;

	@XmlElement(name = "CustomsBrokerCode")
	private String customsBrokerCode;

	@XmlElement(name = "CargoNo")
	private String cargoNo;

	@XmlElement(name = "CargoPiece")
	private String cargoPiece;

	@XmlElement(name = "PieceUnitCode")
	private String pieceUnitCode;

	@XmlElement(name = "CargoWeightGross")
	private String cargoWeightGross;

	@XmlElement(name = "WeightUnitCodeGross")
	private String weightUnitCodeGross;

	@XmlElement(name = "CustomsWarehouseCode")
	private String customsWarehouseCode;

	@XmlElement(name = "CustomsClearanceWarehouseName")
	private String customsClearanceWarehouseName;

	@XmlElement(name = "TheFinalDestinationCode")
	private String theFinalDestinationCode;

	@XmlElement(name = "TheFinalDestinationName")
	private String theFinalDestinationName;

	@XmlElement(name = "LoadingPortCode")
	private String loadingPortCode;

	@XmlElement(name = "LoadingPortName")
	private String loadingPortName;

	@XmlElement(name = "LoadingVesselCode")
	private String loadingVesselCode;

	@XmlElement(name = "LoadingVesselAircraftName")
	private String loadingVesselAircraftName;

	@XmlElement(name = "DeparturePlannedDate")
	private String departurePlannedDate;

	@XmlElement(name = "MarksAndNumbers")
	private String marksAndNumbers;

	@XmlElement(name = "ContractNo")
	private String contractNo;

	@XmlElement(name = "ContractDate")
	private String contractDate;

	@XmlElement(name = "ContractDateEnd")
	private String contractDateEnd;

	@XmlElement(name = "PermitType")
	private String permitType;

	@XmlElement(name = "PermitLicenseNo")
	private String permitLicenseNo;

	@XmlElement(name = "PermitType2")
	private String permitType2;

	@XmlElement(name = "PermitLicenseNo2")
	private String permitLicenseNo2;

	@XmlElement(name = "PermitType3")
	private String permitType3;

	@XmlElement(name = "PermitLicenseNo3")
	private String permitLicenseNo3;

	@XmlElement(name = "PermitType4")
	private String permitType4;

	@XmlElement(name = "PermitLicenseNo4")
	private String permitLicenseNo4;

	@XmlElement(name = "PermitType5")
	private String permitType5;

	@XmlElement(name = "PermitLicenseNo5")
	private String permitLicenseNo5;

	@XmlElement(name = "InvoiceClassificationCode")
	private String invoiceClassificationCode;

	@XmlElement(name = "InvoiceNo")
	private String invoiceNo;

	@XmlElement(name = "ElectronicInvoiceReceiptNo")
	private String electronicInvoiceReceiptNo;

	@XmlElement(name = "InvoiceDate")
	@XmlJavaTypeAdapter(StringDateXMLAdapter.class)
	private LocalDateTime invoiceDate;

	@XmlElement(name = "TermOfPayment")
	private String termOfPayment;

	@XmlElement(name = "InvoicePriceConditionCode")
	private String invoicePriceConditionCode;

	@XmlElement(name = "InvoiceCurrencyCode")
	private String invoiceCurrencyCode;

	@XmlElement(name = "TotalInvoicePrice")
	private String totalInvoicePrice;

	@XmlElement(name = "InvoicePriceKindCode")
	private String invoicePriceKindCode;

	@XmlElement(name = "CurrencyCodeOfTaxValue")
	private String currencyCodeOfTaxValue;

	@XmlElement(name = "TotalOfTaxValue")
	private String totalOfTaxValue;

	@XmlElement(name = "CurrencyCode")
	private String currencyCode;

	@XmlElement(name = "CurrencyExchangeRate")
	private String currencyExchangeRate;

	@XmlElement(name = "CurrencyCode2")
	private String currencyCode2;

	@XmlElement(name = "CurrencyExchangeRate2")
	private String currencyExchangeRate2;

	@XmlElement(name = "TotalOfProportionalTaxValue")
	private String totalOfProportionalTaxValue;

	@XmlElement(name = "TotalBasicPriceInput")
	private String totalBasicPriceInput;

	@XmlElement(name = "ClassificationToVnd")
	private String classificationToVnd;

	@XmlElement(name = "TaxPayer")
	private String taxPayer;

	@XmlElement(name = "CodeOfExtendingDueDate")
	private String codeOfExtendingDueDate;

	@XmlElement(name = "PaymentClassification")
	private String paymentClassification;

	@XmlElement(name = "BankPaymentCode")
	private String bankPaymentCode;

	@XmlElement(name = "BankPaymentIssuedYear")
	private String bankPaymentIssuedYear;

	@XmlElement(name = "BankPaymentSign")
	private String bankPaymentSign;

	@XmlElement(name = "BankPaymentNo")
	private String bankPaymentNo;

	@XmlElement(name = "SecuritySupplierBankCode")
	private String securitySupplierBankCode;

	@XmlElement(name = "SecurityBankSign")
	private String securityBankSign;

	@XmlElement(name = "SecurityNo")
	private String securityNo;

	@XmlElement(name = "TotalExportTax")
	private String totalExportTax;

	@XmlElement(name = "TotalExportTaxCurrencyCode")
	private String totalExportTaxCurrencyCode;

	@XmlElement(name = "TotalCommission")
	private String totalCommission;

	@XmlElement(name = "SecurityAmount")
	private String securityAmount;

	@XmlElement(name = "SecurityAmountCurrencyCode")
	private String securityAmountCurrencyCode;

	@XmlElement(name = "Structure")
	private String structure;

	@XmlElement(name = "NumberOfDeclaration")
	private String numberOfDeclaration;

	@XmlElement(name = "ClassificationOfDossiersAttachment")
	private String classificationOfDossiersAttachment;

	@XmlElement(name = "ElectronicDeclarationNo")
	private String electronicDeclarationNo;

	@XmlElement(name = "ClassificationOfDossiersAttachment2")
	private String classificationOfDossiersAttachment2;

	@XmlElement(name = "ElectronicDeclarationNo2")
	private String electronicDeclarationNo2;

	@XmlElement(name = "ClassificationOfDossiersAttachment3")
	private String classificationOfDossiersAttachment3;

	@XmlElement(name = "ElectronicDeclarationNo3")
	private String electronicDeclarationNo3;

	@XmlElement(name = "Notes")
	private String notes;

	@XmlElement(name = "EnterpriseInternalControlNumber")
	private String enterpriseInternalControlNumber;

	@XmlElement(name = "ManagementNumberUser")
	private String managementNumberUser;

	@XmlElement(name = "DateOfCompletionOfInspection")
	private String dateOfCompletionOfInspection;

	@XmlElement(name = "TimeOfCompletionOfInspection")
	private String timeOfCompletionOfInspection;

	@XmlElement(name = "DateOfPermit")
	private String dateOfPermit;

	@XmlElement(name = "TimeOfPermit")
	private String timeOfPermit;

	@XmlElement(name = "NameOfHeadCustomsOffice")
	private String nameOfHeadCustomsOffice;

	@XmlElement(name = "StartDate")
	private String startDate;

	@XmlElement(name = "TransitLocationForBondedTransport")
	private String transitLocationForBondedTransport;

	@XmlElement(name = "ArrivalDateTransport")
	private String arrivalDateTransport;

	@XmlElement(name = "StartDateOfTransport")
	private String startDateOfTransport;

	@XmlElement(name = "TransitLocationForBondedTransport2")
	private String transitLocationForBondedTransport2;

	@XmlElement(name = "ArrivalDateTransport2")
	private String arrivalDateTransport2;

	@XmlElement(name = "StartDateOfTransport2")
	private String startDateOfTransport2;

	@XmlElement(name = "TransitLocationForBondedTransport3")
	private String transitLocationForBondedTransport3;

	@XmlElement(name = "ArrivalDateTransport3")
	private String arrivalDateTransport3;

	@XmlElement(name = "StartDateOfTransport3")
	private String startDateOfTransport3;

	@XmlElement(name = "DestinationLocationForBondedTransport")
	private String destinationLocationForBondedTransport;

	@XmlElement(name = "ArrivalDateOfTransport")
	private String arrivalDateOfTransport;

	@XmlElement(name = "VanningPlaceCode")
	private String vanningPlaceCode;

	@XmlElement(name = "VanningPlaceCode2")
	private String vanningPlaceCode2;

	@XmlElement(name = "VanningPlaceCode3")
	private String vanningPlaceCode3;

	@XmlElement(name = "VanningPlaceCode4")
	private String vanningPlaceCode4;

	@XmlElement(name = "VanningPlaceCode5")
	private String vanningPlaceCode5;

	@XmlElement(name = "VanningPlaceName")
	private String vanningPlaceName;

	@XmlElement(name = "VanningPlaceAddress")
	private String vanningPlaceAddress;

	@XmlElement(name = "ContainerNo")
	private String containerNo;

	@XmlElement(name = "ContainerNo2")
	private String containerNo2;

	@XmlElement(name = "ContainerNo3")
	private String containerNo3;

	@XmlElement(name = "ContainerNo4")
	private String containerNo4;

	@XmlElement(name = "ContainerNo5")
	private String containerNo5;

	@XmlElement(name = "ContainerNo6")
	private String containerNo6;

	@XmlElement(name = "ContainerNo7")
	private String containerNo7;

	@XmlElement(name = "ContainerNo8")
	private String containerNo8;

	@XmlElement(name = "ContainerNo9")
	private String containerNo9;

	@XmlElement(name = "ContainerNo10")
	private String containerNo10;

	@XmlElement(name = "ContainerNo11")
	private String containerNo11;

	@XmlElement(name = "ContainerNo12")
	private String containerNo12;

	@XmlElement(name = "ContainerNo13")
	private String containerNo13;

	@XmlElement(name = "ContainerNo14")
	private String containerNo14;

	@XmlElement(name = "ContainerNo15")
	private String containerNo15;

	@XmlElement(name = "ContainerNo16")
	private String containerNo16;

	@XmlElement(name = "ContainerNo17")
	private String containerNo17;

	@XmlElement(name = "ContainerNo18")
	private String containerNo18;

	@XmlElement(name = "ContainerNo19")
	private String containerNo19;

	@XmlElement(name = "ContainerNo20")
	private String containerNo20;

	@XmlElement(name = "ContainerNo21")
	private String containerNo21;

	@XmlElement(name = "ContainerNo22")
	private String containerNo22;

	@XmlElement(name = "ContainerNo23")
	private String containerNo23;

	@XmlElement(name = "ContainerNo24")
	private String containerNo24;

	@XmlElement(name = "ContainerNo25")
	private String containerNo25;

	@XmlElement(name = "ContainerNo26")
	private String containerNo26;

	@XmlElement(name = "ContainerNo27")
	private String containerNo27;

	@XmlElement(name = "ContainerNo28")
	private String containerNo28;

	@XmlElement(name = "ContainerNo29")
	private String containerNo29;

	@XmlElement(name = "ContainerNo30")
	private String containerNo30;

	@XmlElement(name = "ContainerNo31")
	private String containerNo31;

	@XmlElement(name = "ContainerNo32")
	private String containerNo32;

	@XmlElement(name = "ContainerNo33")
	private String containerNo33;

	@XmlElement(name = "ContainerNo34")
	private String containerNo34;

	@XmlElement(name = "ContainerNo35")
	private String containerNo35;

	@XmlElement(name = "ContainerNo36")
	private String containerNo36;

	@XmlElement(name = "ContainerNo37")
	private String containerNo37;

	@XmlElement(name = "ContainerNo38")
	private String containerNo38;

	@XmlElement(name = "ContainerNo39")
	private String containerNo39;

	@XmlElement(name = "ContainerNo40")
	private String containerNo40;

	@XmlElement(name = "ContainerNo41")
	private String containerNo41;

	@XmlElement(name = "ContainerNo42")
	private String containerNo42;

	@XmlElement(name = "ContainerNo43")
	private String containerNo43;

	@XmlElement(name = "ContainerNo44")
	private String containerNo44;

	@XmlElement(name = "ContainerNo45")
	private String containerNo45;

	@XmlElement(name = "ContainerNo46")
	private String containerNo46;

	@XmlElement(name = "ContainerNo47")
	private String containerNo47;

	@XmlElement(name = "ContainerNo48")
	private String containerNo48;

	@XmlElement(name = "ContainerNo49")
	private String containerNo49;

	@XmlElement(name = "ContainerNo50")
	private String containerNo50;

	@XmlElement(name = "CustomsInstructionClassification")
	private String customsInstructionClassification;

	@XmlElement(name = "DateOfCustomsInstruction")
	private String dateOfCustomsInstruction;

	@XmlElement(name = "CaseTitleOfCustomsInstruction")
	private String caseTitleOfCustomsInstruction;

	@XmlElement(name = "ContentOfCustomsInstruction")
	private String contentOfCustomsInstruction;

	@XmlElement(name = "DateOfCustomsInstruction2")
	private String dateOfCustomsInstruction2;

	@XmlElement(name = "CaseTitleOfCustomsInstruction2")
	private String caseTitleOfCustomsInstruction2;

	@XmlElement(name = "ContentOfCustomsInstruction2")
	private String contentOfCustomsInstruction2;

	@XmlElement(name = "DateOfCustomsInstruction3")
	private String dateOfCustomsInstruction3;

	@XmlElement(name = "CaseTitleOfCustomsInstruction3")
	private String caseTitleOfCustomsInstruction3;

	@XmlElement(name = "ContentOfCustomsInstruction3")
	private String contentOfCustomsInstruction3;

	@XmlElement(name = "DateOfCustomsInstruction4")
	private String dateOfCustomsInstruction4;

	@XmlElement(name = "CaseTitleOfCustomsInstruction4")
	private String caseTitleOfCustomsInstruction4;

	@XmlElement(name = "ContentOfCustomsInstruction4")
	private String contentOfCustomsInstruction4;

	@XmlElement(name = "DateOfCustomsInstruction5")
	private String dateOfCustomsInstruction5;

	@XmlElement(name = "CaseTitleOfCustomsInstruction5")
	private String caseTitleOfCustomsInstruction5;

	@XmlElement(name = "ContentOfCustomsInstruction5")
	private String contentOfCustomsInstruction5;

	@XmlElement(name = "DateOfCustomsInstruction6")
	private String dateOfCustomsInstruction6;

	@XmlElement(name = "CaseTitleOfCustomsInstruction6")
	private String caseTitleOfCustomsInstruction6;

	@XmlElement(name = "ContentOfCustomsInstruction6")
	private String contentOfCustomsInstruction6;

	@XmlElement(name = "DateOfCustomsInstruction7")
	private String dateOfCustomsInstruction7;

	@XmlElement(name = "CaseTitleOfCustomsInstruction7")
	private String caseTitleOfCustomsInstruction7;

	@XmlElement(name = "ContentOfCustomsInstruction7")
	private String contentOfCustomsInstruction7;

	@XmlElement(name = "DateOfCustomsInstruction8")
	private String dateOfCustomsInstruction8;

	@XmlElement(name = "CaseTitleOfCustomsInstruction8")
	private String caseTitleOfCustomsInstruction8;

	@XmlElement(name = "ContentOfCustomsInstruction8")
	private String contentOfCustomsInstruction8;

	@XmlElement(name = "DateOfCustomsInstruction9")
	private String dateOfCustomsInstruction9;

	@XmlElement(name = "CaseTitleOfCustomsInstruction9")
	private String caseTitleOfCustomsInstruction9;

	@XmlElement(name = "ContentOfCustomsInstruction9")
	private String contentOfCustomsInstruction9;

	@XmlElement(name = "DateOfCustomsInstruction10")
	private String dateOfCustomsInstruction10;

	@XmlElement(name = "CaseTitleOfCustomsInstruction10")
	private String caseTitleOfCustomsInstruction10;

	@XmlElement(name = "ContentOfCustomsInstruction10")
	private String contentOfCustomsInstruction10;

	@XmlElement(name = "ContractNoExport")
	private String contractNoExport;

	@XmlElement(name = "RecordNo")
	private String recordNo;

	@XmlElement(name = "Supplier")
	private String supplier;

	@XmlElement(name = "PaymentVoucherNumber")
	private String paymentVoucherNumber;

	@XmlElement(name = "PaymentVoucherDate")
	private String paymentVoucherDate;

}
