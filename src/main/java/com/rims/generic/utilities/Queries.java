package com.rims.generic.utilities;

public class Queries {

	public static final String PRODUCT_CLASSIFICATION = "INSERT INTO PRODUCT_CLASSIFICATION (ID,CREATION_TIME_STAMP,PARENT_CATEGORY1,PARENT_CATEGORY2,SUB_CATEGORY1,SUB_CATEGORY2) VALUES({id}, systimestamp,'{parentCategory1}','{parentCategory2}','{subCategory1}','{subCategory2}');";
	public static final String VENDOR = "INSERT INTO VENDOR (ID,CREATION_TIME_STAMP,CODE,DESCRIPTION,NAME,GST_NUMBER,BANK_DETAILS) VALUES({id}, systimestamp,'{code}', '{description}', '{name}', '{gstNumber}', '{bankDetails}');";
	public static final String BANK_DETAILS = "INSERT INTO BANK_DETAILS (ID,CREATION_TIME_STAMP,ACCOUNT_HOLDER_NAME,ACCOUNT_NUMBER,ACCOUNT_TYPE,BANK_BRANCH,BANK_NAME,IFSC_CODE,VENDOR_FK) VALUES({id},systimestamp,'{accountHolderName}', '{accountNumber}', '{accountType}', '{bankBranch}','{bankName}', '{ifscCode}','{vendorFk}');";
	public static final String CONTANCT_INFO = "INSERT INTO 'CONTACT_INFO (ID,CREATION_TIME_STAMP,CONTACT_PERSON,EMAIL,VENDOR_FK) VALUES({id}, systimestamp, '{contactPerson}', '{email}', '{vendorFk}');";
	public static final String PHONE_NUMBER = "INSERT INTO PHONE_NUMBER (ID,CREATION_TIME_STAMP,PHONE_EXTENSION,PHONE_NUMBER,PHONE_TYPE,CONTACT_INFO_FK) VALUES({id},systimestamp,'{phoneExtension}','{phoneNumber}','{phoneType}','{contactInfoFk}');";
	public static final String ADDRESS = "INSERT INTO ADDRESS(ID,CREATION_TIME_STAMP,ADDRESS_LINE1,ADDRESS_LINE2,AREA_NAME,CITY_NAME,COUNTRY_CODE,COUNTRY_NAME,STATE_NAME,ZIP_CODE,CONTACT_INFO_FK) VALUES({id}, systimestamp, '{addressLine1}', '{addressLine2}','{areaName}', '{cityName}', '{countryCode}', '{countryName}', '{stateName}', '{zipCode}', '{contactInfoFk}');";
	public static final String VENDOR_PRODUCT = "INSERT INTO VENDOR_PRODUCT(VENDOR_ID,PRODUCT_ID) VALUES('{vendorId}','{productId}');";
	public static final String PRODUCT = "insert into product (ID , CREATION_TIME_STAMP ,ACTIVE_FLAG,APPROVAL_STATUS,VISIBILITY , CODE , NAME , DESCRIPTION,BRAND ,PRODUCT_CLASSFICATION_FK) values ({id},systimestamp,TRUE,0,TRUE,'{code}','{name}','{description}','{brand}',{productClassification});";
	public static final String PRODUCT_ATTRIBUTE = "insert into product_attribute(product_id , attribute_id) values('{productId}','{attributeId}');";
	public static final String GENERIC_ATTRIBUTE = "insert into generic_attribute(ID , CREATION_TIME_STAMP ,ACTIVE_FLAG,APPROVAL_STATUS,VISIBILITY , DTYPE , CODE , NAME , DESCRIPTION ,PARENT_ATTRIBUTE) values ({id},systimestamp,TRUE,0,TRUE,'{dtype}','{code}','{name}','{description}','{parentAttribute}');";
	public static final String USERS = "INSERT INTO USERS(id,CREATION_TIME_STAMP,ACCOUNT_EXPIRED,ACCOUNT_LOCKED,CREDENTIALS_EXPIRED,PASSWORD,USER_ENABLED,USERNAME,USER_ADD_INFO_FK) VALUES({id}, systimestamp, FALSE, FALSE, FALSE, '{password}', TRUE, '{username}', '{userAddInfoFk}');";
	public static final String ROLES = "INSERT INTO ROLE(id,CREATION_TIME_STAMP,ACTIVE_FLAG,APPROVAL_STATUS,CODE,DESCRIPTION,NAME,VISIBILITY) VALUES({id}, systimestamp, TRUE, 0, '{code}','{description}', '{name}',TRUE);";
	public static final String AUTHORITY = "INSERT INTO AUTHORITY(id,CREATION_TIME_STAMP,ACTIVE_FLAG,APPROVAL_STATUS,CODE,DESCRIPTION,NAME,VISIBILITY) VALUES({id}, systimestamp, TRUE, 0, '{code}','{description}', '{name}',TRUE);";
	public static final String ROLE_AUTHORITY = "INSERT INTO ROLE_AUTHORITY(ROLE_ID,AUTHORITY_ID) VALUES('{roleId}', '{authorityId}');";
	public static final String ROLE_USERS = "INSERT INTO ROLE_USERS(USER_ID,ROLE_ID) VALUES('{userId}', '{roleId}');";
	public static final String USER_ADDITIONAL_INFO = "INSERT INTO USER_ADDITIONAL_INFO(id,CREATION_TIME_STAMP,FIRSTNAME,LASTNAME,PROFILE_IMAGE_LINK) VALUES({id}, systimestamp, '{firstname}', '{lastname}', '{profilePicLink}'); ";
}
