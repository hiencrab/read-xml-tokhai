package com.thaison.xml.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.thaison.xml.entity.BaseEntityJpa;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(schema = "public", name = "DECLARATION_REPORT")
public class DeclarationReportEntity extends BaseEntityJpa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "HEADER_ID")
	private Long headerId;

	@Column(name = "DECLARATION_NO")
	private String declarationNo;

	@Column(name = "CLASSIFICATION_OF_OUTPUTTING")
	private String classificationOfOutputting;

	@Column(name = "FIRST_DECLARATION_NO")
	private String firstDeclarationNo;

	@Column(name = "BRANCH_NUMBER_OF_DIVIDED_DECLARATION")
	private String branchNumberOfDividedDeclaration;

	@Column(name = "NUMBER_OF_DIVISIONS_OF_DIVIDED_DECLARATION")
	private String numberOfDivisionsOfDividedDeclaration;

	@Column(name = "DECLARATION_NUMBER_OF_TENTATIVE")
	private String declarationNumberOfTentative;

	@Column(name = "APP_NAME")
	private String appName;

	@Column(name = "INSPECTION_KIND_CLASSIFICATION")
	private String inspectionKindClassification;

	@Column(name = "DECLARATION_STATUS")
	private String declarationStatus;

	@Column(name = "DECLARATION_VERSION")
	private String declarationVersion;

	@Column(name = "DECLARATION_KIND_CODE")
	private String declarationKindCode;

	@Column(name = "CARGO_CLASSIFICATION_CODE")
	private String cargoClassificationCode;

	@Column(name = "MEANS_OF_TRANSPORTATION")
	private String meansOfTransportation;

	@Column(name = "REPRESENTATIVE_TAX_CODE")
	private String representativeTaxCode;

	@Column(name = "CUSTOMS_OFFICE_CODE")
	private String customsOfficeCode;

	@Column(name = "CUSTOMS_OFFICE_NAME")
	private String customsOfficeName;

	@Column(name = "CUSTOMS_SUB_SECTION")
	private String customsSubSection;

	@Column(name = "REGISTERED_DATE")
	private String registeredDate;

	@Column(name = "REGISTERED_TIME")
	private String registeredTime;

	@Column(name = "REGISTERED_DATE_OF_CORRECTION")
	private String registeredDateOfCorrection;

	@Column(name = "REGISTERED_TIME_OF_CORRECTION")
	private String registeredTimeOfCorrection;

	@Column(name = "TIME_LIMIT_OF_RE_IMPORT")
	private String timeLimitOfReImport;

	@Column(name = "SIGN_OF_TIME_LIMIT_OVER")
	private String signOfTimeLimitOver;

	@Column(name = "EXPORTER_CODE")
	private String exporterCode;

	@Column(name = "EXPORTER_NAME")
	private String exporterName;

	@Column(name = "POST_CODE")
	private String postCode;

	@Column(name = "ADDRESS_OF_EXPORTER")
	private String addressOfExporter;

	@Column(name = "TELEPHONE_NUMBER")
	private String telephoneNumber;

	@Column(name = "EXPORTER_CONTRACTOR_CODE")
	private String exporterContractorCode;

	@Column(name = "EXPORTER_CONTRACTOR_NAME")
	private String exporterContractorName;

	@Column(name = "CONSIGNEE_CODE")
	private String consigneeCode;

	@Column(name = "CONSIGNEE_NAME")
	private String consigneeName;

	@Column(name = "POST_CODE_IDENTIFICATION")
	private String postCodeIdentification;

	@Column(name = "ADDRESS_1")
	private String address1;

	@Column(name = "ADDRESS_2")
	private String address2;

	@Column(name = "ADDRESS_3")
	private String address3;

	@Column(name = "ADDRESS_4")
	private String address4;

	@Column(name = "COUNTRY_CODE")
	private String countryCode;

	@Column(name = "PLANNED_DECLARANT_CODE")
	private String plannedDeclarantCode;

	@Column(name = "AGENT_NAME")
	private String agentName;

	@Column(name = "CUSTOMS_BROKER_CODE")
	private String customsBrokerCode;

	@Column(name = "CARGO_NO")
	private String cargoNo;

	@Column(name = "CARGO_PIECE")
	private String cargoPiece;

	@Column(name = "PIECE_UNIT_CODE")
	private String pieceUnitCode;

	@Column(name = "CARGO_WEIGHT_GROSS")
	private String cargoWeightGross;

	@Column(name = "WEIGHT_UNIT_CODE_GROSS")
	private String weightUnitCodeGross;

	@Column(name = "CUSTOMS_WAREHOUSE_CODE")
	private String customsWarehouseCode;

	@Column(name = "CUSTOMS_CLEARANCE_WAREHOUSE_NAME")
	private String customsClearanceWarehouseName;

	@Column(name = "THE_FINAL_DESTINATION_CODE")
	private String theFinalDestinationCode;

	@Column(name = "THE_FINAL_DESTINATION_NAME")
	private String theFinalDestinationName;

	@Column(name = "LOADING_PORT_CODE")
	private String loadingPortCode;

	@Column(name = "LOADING_PORT_NAME")
	private String loadingPortName;

	@Column(name = "LOADING_VESSEL_CODE")
	private String loadingVesselCode;

	@Column(name = "LOADING_VESSEL_AIRCRAFT_NAME")
	private String loadingVesselAircraftName;

	@Column(name = "DEPARTURE_PLANNED_DATE")
	private String departurePlannedDate;

	@Column(name = "MARKS_AND_NUMBERS")
	private String marksAndNumbers;

	@Column(name = "CONTRACT_NO")
	private String contractNo;

	@Column(name = "CONTRACT_DATE")
	private String contractDate;

	@Column(name = "CONTRACT_DATE_END")
	private String contractDateEnd;

	@Column(name = "PERMIT_TYPE")
	private String permitType;

	@Column(name = "PERMIT_LICENSE_NO")
	private String permitLicenseNo;

	@Column(name = "PERMIT_TYPE_2")
	private String permitType2;

	@Column(name = "PERMIT_LICENSE_NO_2")
	private String permitLicenseNo2;

	@Column(name = "PERMIT_TYPE_3")
	private String permitType3;

	@Column(name = "PERMIT_LICENSE_NO_3")
	private String permitLicenseNo3;

	@Column(name = "PERMIT_TYPE_4")
	private String permitType4;

	@Column(name = "PERMIT_LICENSE_NO_4")
	private String permitLicenseNo4;

	@Column(name = "PERMIT_TYPE_5")
	private String permitType5;

	@Column(name = "PERMIT_LICENSE_NO_5")
	private String permitLicenseNo5;

	@Column(name = "INVOICE_CLASSIFICATION_CODE")
	private String invoiceClassificationCode;

	@Column(name = "INVOICE_NO")
	private String invoiceNo;

	@Column(name = "ELECTRONIC_INVOICE_RECEIPT_NO")
	private String electronicInvoiceReceiptNo;

	@Column(name = "INVOICE_DATE")
	private LocalDateTime invoiceDate;

	@Column(name = "TERM_OF_PAYMENT")
	private String termOfPayment;

	@Column(name = "INVOICE_PRICE_CONDITION_CODE")
	private String invoicePriceConditionCode;

	@Column(name = "INVOICE_CURRENCY_CODE")
	private String invoiceCurrencyCode;

	@Column(name = "TOTAL_INVOICE_PRICE")
	private String totalInvoicePrice;

	@Column(name = "INVOICE_PRICE_KIND_CODE")
	private String invoicePriceKindCode;

	@Column(name = "CURRENCY_CODE_OF_TAX_VALUE")
	private String currencyCodeOfTaxValue;

	@Column(name = "TOTAL_OF_TAX_VALUE")
	private String totalOfTaxValue;

	@Column(name = "CURRENCY_CODE")
	private String currencyCode;

	@Column(name = "CURRENCY_EXCHANGE_RATE")
	private String currencyExchangeRate;

	@Column(name = "CURRENCY_CODE_2")
	private String currencyCode2;

	@Column(name = "CURRENCY_EXCHANGE_RATE_2")
	private String currencyExchangeRate2;

	@Column(name = "TOTAL_OF_PROPORTIONAL_TAX_VALUE")
	private String totalOfProportionalTaxValue;

	@Column(name = "TOTAL_BASIC_PRICE_INPUT")
	private String totalBasicPriceInput;

	@Column(name = "CLASSIFICATION_TO_VND")
	private String classificationToVnd;

	@Column(name = "TAX_PAYER")
	private String taxPayer;

	@Column(name = "CODE_OF_EXTENDING_DUE_DATE")
	private String codeOfExtendingDueDate;

	@Column(name = "PAYMENT_CLASSIFICATION")
	private String paymentClassification;

	@Column(name = "BANK_PAYMENT_CODE")
	private String bankPaymentCode;

	@Column(name = "BANK_PAYMENT_ISSUED_YEAR")
	private String bankPaymentIssuedYear;

	@Column(name = "BANK_PAYMENT_SIGN")
	private String bankPaymentSign;

	@Column(name = "BANK_PAYMENT_NO")
	private String bankPaymentNo;

	@Column(name = "SECURITY_SUPPLIER_BANK_CODE")
	private String securitySupplierBankCode;

	@Column(name = "SECURITY_BANK_SIGN")
	private String securityBankSign;

	@Column(name = "SECURITY_NO")
	private String securityNo;

	@Column(name = "TOTAL_EXPORT_TAX")
	private String totalExportTax;

	@Column(name = "TOTAL_EXPORT_TAX_CURRENCY_CODE")
	private String totalExportTaxCurrencyCode;

	@Column(name = "TOTAL_COMMISSION")
	private String totalCommission;

	@Column(name = "SECURITY_AMOUNT")
	private String securityAmount;

	@Column(name = "SECURITY_AMOUNT_CURRENCY_CODE")
	private String securityAmountCurrencyCode;

	@Column(name = "STRUCTURE")
	private String structure;

	@Column(name = "NUMBER_OF_DECLARATION")
	private String numberOfDeclaration;

	@Column(name = "CLASSIFICATION_OF_DOSSIERS_ATTACHMENT")
	private String classificationOfDossiersAttachment;

	@Column(name = "ELECTRONIC_DECLARATION_NO")
	private String electronicDeclarationNo;

	@Column(name = "CLASSIFICATION_OF_DOSSIERS_ATTACHMENT_2")
	private String classificationOfDossiersAttachment2;

	@Column(name = "ELECTRONIC_DECLARATION_NO_2")
	private String electronicDeclarationNo2;

	@Column(name = "CLASSIFICATION_OF_DOSSIERS_ATTACHMENT_3")
	private String classificationOfDossiersAttachment3;

	@Column(name = "ELECTRONIC_DECLARATION_NO_3")
	private String electronicDeclarationNo3;

	@Column(name = "NOTES")
	private String notes;

	@Column(name = "ENTERPRISE_INTERNAL_CONTROL_NUMBER")
	private String enterpriseInternalControlNumber;

	@Column(name = "MANAGEMENT_NUMBER_USER")
	private String managementNumberUser;

	@Column(name = "DATE_OF_COMPLETION_OF_INSPECTION")
	private String dateOfCompletionOfInspection;

	@Column(name = "TIME_OF_COMPLETION_OF_INSPECTION")
	private String timeOfCompletionOfInspection;

	@Column(name = "DATE_OF_PERMIT")
	private String dateOfPermit;

	@Column(name = "TIME_OF_PERMIT")
	private String timeOfPermit;

	@Column(name = "NAME_OF_HEAD_CUSTOMS_OFFICE")
	private String nameOfHeadCustomsOffice;

	@Column(name = "START_DATE")
	private String startDate;

	@Column(name = "TRANSIT_LOCATION_FOR_BONDED_TRANSPORT")
	private String transitLocationForBondedTransport;

	@Column(name = "ARRIVAL_DATE_TRANSPORT")
	private String arrivalDateTransport;

	@Column(name = "START_DATE_OF_TRANSPORT")
	private String startDateOfTransport;

	@Column(name = "TRANSIT_LOCATION_FOR_BONDED_TRANSPORT_2")
	private String transitLocationForBondedTransport2;

	@Column(name = "ARRIVAL_DATE_TRANSPORT_2")
	private String arrivalDateTransport2;

	@Column(name = "START_DATE_OF_TRANSPORT_2")
	private String startDateOfTransport2;

	@Column(name = "TRANSIT_LOCATION_FOR_BONDED_TRANSPORT_3")
	private String transitLocationForBondedTransport3;

	@Column(name = "ARRIVAL_DATE_TRANSPORT_3")
	private String arrivalDateTransport3;

	@Column(name = "START_DATE_OF_TRANSPORT_3")
	private String startDateOfTransport3;

	@Column(name = "DESTINATION_LOCATION_FOR_BONDED_TRANSPORT")
	private String destinationLocationForBondedTransport;

	@Column(name = "ARRIVAL_DATE_OF_TRANSPORT")
	private String arrivalDateOfTransport;

	@Column(name = "VANNING_PLACE_CODE")
	private String vanningPlaceCode;

	@Column(name = "VANNING_PLACE_CODE_2")
	private String vanningPlaceCode2;

	@Column(name = "VANNING_PLACE_CODE_3")
	private String vanningPlaceCode3;

	@Column(name = "VANNING_PLACE_CODE_4")
	private String vanningPlaceCode4;

	@Column(name = "VANNING_PLACE_CODE_5")
	private String vanningPlaceCode5;

	@Column(name = "VANNING_PLACE_NAME")
	private String vanningPlaceName;

	@Column(name = "VANNING_PLACE_ADDRESS")
	private String vanningPlaceAddress;

	@Column(name = "CONTAINER_NO")
	private String containerNo;

	@Column(name = "CONTAINER_NO_2")
	private String containerNo2;

	@Column(name = "CONTAINER_NO_3")
	private String containerNo3;

	@Column(name = "CONTAINER_NO_4")
	private String containerNo4;

	@Column(name = "CONTAINER_NO_5")
	private String containerNo5;

	@Column(name = "CONTAINER_NO_6")
	private String containerNo6;

	@Column(name = "CONTAINER_NO_7")
	private String containerNo7;

	@Column(name = "CONTAINER_NO_8")
	private String containerNo8;

	@Column(name = "CONTAINER_NO_9")
	private String containerNo9;

	@Column(name = "CONTAINER_NO_10")
	private String containerNo10;

	@Column(name = "CONTAINER_NO_11")
	private String containerNo11;

	@Column(name = "CONTAINER_NO_12")
	private String containerNo12;

	@Column(name = "CONTAINER_NO_13")
	private String containerNo13;

	@Column(name = "CONTAINER_NO_14")
	private String containerNo14;

	@Column(name = "CONTAINER_NO_15")
	private String containerNo15;

	@Column(name = "CONTAINER_NO_16")
	private String containerNo16;

	@Column(name = "CONTAINER_NO_17")
	private String containerNo17;

	@Column(name = "CONTAINER_NO_18")
	private String containerNo18;

	@Column(name = "CONTAINER_NO_19")
	private String containerNo19;

	@Column(name = "CONTAINER_NO_20")
	private String containerNo20;

	@Column(name = "CONTAINER_NO_21")
	private String containerNo21;

	@Column(name = "CONTAINER_NO_22")
	private String containerNo22;

	@Column(name = "CONTAINER_NO_23")
	private String containerNo23;

	@Column(name = "CONTAINER_NO_24")
	private String containerNo24;

	@Column(name = "CONTAINER_NO_25")
	private String containerNo25;

	@Column(name = "CONTAINER_NO_26")
	private String containerNo26;

	@Column(name = "CONTAINER_NO_27")
	private String containerNo27;

	@Column(name = "CONTAINER_NO_28")
	private String containerNo28;

	@Column(name = "CONTAINER_NO_29")
	private String containerNo29;

	@Column(name = "CONTAINER_NO_30")
	private String containerNo30;

	@Column(name = "CONTAINER_NO_31")
	private String containerNo31;

	@Column(name = "CONTAINER_NO_32")
	private String containerNo32;

	@Column(name = "CONTAINER_NO_33")
	private String containerNo33;

	@Column(name = "CONTAINER_NO_34")
	private String containerNo34;

	@Column(name = "CONTAINER_NO_35")
	private String containerNo35;

	@Column(name = "CONTAINER_NO_36")
	private String containerNo36;

	@Column(name = "CONTAINER_NO_37")
	private String containerNo37;

	@Column(name = "CONTAINER_NO_38")
	private String containerNo38;

	@Column(name = "CONTAINER_NO_39")
	private String containerNo39;

	@Column(name = "CONTAINER_NO_40")
	private String containerNo40;

	@Column(name = "CONTAINER_NO_41")
	private String containerNo41;

	@Column(name = "CONTAINER_NO_42")
	private String containerNo42;

	@Column(name = "CONTAINER_NO_43")
	private String containerNo43;

	@Column(name = "CONTAINER_NO_44")
	private String containerNo44;

	@Column(name = "CONTAINER_NO_45")
	private String containerNo45;

	@Column(name = "CONTAINER_NO_46")
	private String containerNo46;

	@Column(name = "CONTAINER_NO_47")
	private String containerNo47;

	@Column(name = "CONTAINER_NO_48")
	private String containerNo48;

	@Column(name = "CONTAINER_NO_49")
	private String containerNo49;

	@Column(name = "CONTAINER_NO_50")
	private String containerNo50;

	@Column(name = "CUSTOMS_INSTRUCTION_CLASSIFICATION")
	private String customsInstructionClassification;

	@Column(name = "DATE_OF_CUSTOMS_INSTRUCTION")
	private String dateOfCustomsInstruction;

	@Column(name = "CASE_TITLE_OF_CUSTOMS_INSTRUCTION")
	private String caseTitleOfCustomsInstruction;

	@Column(name = "CONTENT_OF_CUSTOMS_INSTRUCTION")
	private String contentOfCustomsInstruction;

	@Column(name = "DATE_OF_CUSTOMS_INSTRUCTION_2")
	private String dateOfCustomsInstruction2;

	@Column(name = "CASE_TITLE_OF_CUSTOMS_INSTRUCTION_2")
	private String caseTitleOfCustomsInstruction2;

	@Column(name = "CONTENT_OF_CUSTOMS_INSTRUCTION_2")
	private String contentOfCustomsInstruction2;

	@Column(name = "DATE_OF_CUSTOMS_INSTRUCTION_3")
	private String dateOfCustomsInstruction3;

	@Column(name = "CASE_TITLE_OF_CUSTOMS_INSTRUCTION_3")
	private String caseTitleOfCustomsInstruction3;

	@Column(name = "CONTENT_OF_CUSTOMS_INSTRUCTION_3")
	private String contentOfCustomsInstruction3;

	@Column(name = "DATE_OF_CUSTOMS_INSTRUCTION_4")
	private String dateOfCustomsInstruction4;

	@Column(name = "CASE_TITLE_OF_CUSTOMS_INSTRUCTION_4")
	private String caseTitleOfCustomsInstruction4;

	@Column(name = "CONTENT_OF_CUSTOMS_INSTRUCTION_4")
	private String contentOfCustomsInstruction4;

	@Column(name = "DATE_OF_CUSTOMS_INSTRUCTION_5")
	private String dateOfCustomsInstruction5;

	@Column(name = "CASE_TITLE_OF_CUSTOMS_INSTRUCTION_5")
	private String caseTitleOfCustomsInstruction5;

	@Column(name = "CONTENT_OF_CUSTOMS_INSTRUCTION_5")
	private String contentOfCustomsInstruction5;

	@Column(name = "DATE_OF_CUSTOMS_INSTRUCTION_6")
	private String dateOfCustomsInstruction6;

	@Column(name = "CASE_TITLE_OF_CUSTOMS_INSTRUCTION_6")
	private String caseTitleOfCustomsInstruction6;

	@Column(name = "CONTENT_OF_CUSTOMS_INSTRUCTION_6")
	private String contentOfCustomsInstruction6;

	@Column(name = "DATE_OF_CUSTOMS_INSTRUCTION_7")
	private String dateOfCustomsInstruction7;

	@Column(name = "CASE_TITLE_OF_CUSTOMS_INSTRUCTION_7")
	private String caseTitleOfCustomsInstruction7;

	@Column(name = "CONTENT_OF_CUSTOMS_INSTRUCTION_7")
	private String contentOfCustomsInstruction7;

	@Column(name = "DATE_OF_CUSTOMS_INSTRUCTION_8")
	private String dateOfCustomsInstruction8;

	@Column(name = "CASE_TITLE_OF_CUSTOMS_INSTRUCTION_8")
	private String caseTitleOfCustomsInstruction8;

	@Column(name = "CONTENT_OF_CUSTOMS_INSTRUCTION_8")
	private String contentOfCustomsInstruction8;

	@Column(name = "DATE_OF_CUSTOMS_INSTRUCTION_9")
	private String dateOfCustomsInstruction9;

	@Column(name = "CASE_TITLE_OF_CUSTOMS_INSTRUCTION_9")
	private String caseTitleOfCustomsInstruction9;

	@Column(name = "CONTENT_OF_CUSTOMS_INSTRUCTION_9")
	private String contentOfCustomsInstruction9;

	@Column(name = "DATE_OF_CUSTOMS_INSTRUCTION_10")
	private String dateOfCustomsInstruction10;

	@Column(name = "CASE_TITLE_OF_CUSTOMS_INSTRUCTION_10")
	private String caseTitleOfCustomsInstruction10;

	@Column(name = "CONTENT_OF_CUSTOMS_INSTRUCTION_10")
	private String contentOfCustomsInstruction10;

	@Column(name = "CONTRACT_NO_EXPORT")
	private String contractNoExport;

	@Column(name = "RECORD_NO")
	private String recordNo;

	@Column(name = "SUPPLIER")
	private String supplier;

	@Column(name = "PAYMENT_VOUCHER_NUMBER")
	private String paymentVoucherNumber;

	@Column(name = "PAYMENT_VOUCHER_DATE")
	private String paymentVoucherDate;

}
