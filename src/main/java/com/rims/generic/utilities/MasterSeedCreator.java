package com.rims.generic.utilities;

public class MasterSeedCreator {

	public static String createProductClassisifcationQuery(String id, String parentCategory1, String parentCategory2,
			String subCategory1, String subCategory2) {
		return Queries.PRODUCT_CLASSIFICATION.replace(QueryConstants.ID, id)
				.replace(QueryConstants.PARENT_CATEGORY_1, parentCategory1)
				.replace(QueryConstants.PARENT_CATEGORY_2, parentCategory2)
				.replace(QueryConstants.SUB_CATEGORY_1, subCategory1)
				.replace(QueryConstants.SUB_CATEGORY_2, subCategory2).replace("'null'", "null").replace("''", "null");
	}

	public static String createVendorQuery(String id, String code, String description, String name, String gstNumber,
			String bankDetails) {
		return Queries.VENDOR.replace(QueryConstants.ID, id).replace(QueryConstants.CODE, code)
				.replace(QueryConstants.DESCRIPTION, description).replace(QueryConstants.NAME, name)
				.replace(QueryConstants.GST_NUMBER, gstNumber).replace(QueryConstants.BANK_DETAILS, bankDetails)
				.replace("'null'", "null").replace("''", "null");
	}

	public static String createBankDetailsQuery(String id, String accountHolderName, String accountNumber,
			String accountType, String bankBranch, String bankName, String ifscCode, String vendorFk) {
		return Queries.BANK_DETAILS.replace(QueryConstants.ID, id)
				.replace(QueryConstants.ACCOUNT_HOLDER_NAME, accountHolderName)
				.replace(QueryConstants.ACCOUNT_NUMBER, accountNumber).replace(QueryConstants.ACCOUNT_TYPE, accountType)
				.replace(QueryConstants.BANK_BRANCH, bankBranch).replace(QueryConstants.BANK_NAME, bankName)
				.replace(QueryConstants.IFSC_CODE, ifscCode).replace(QueryConstants.VENDOR_FK, vendorFk)
				.replace("'null'", "null").replace("''", "null");
	}

	public static String createContactInfoQuery(String id, String contactPerson, String email, String vendorFk) {
		return Queries.CONTANCT_INFO.replace(QueryConstants.ID, id)
				.replace(QueryConstants.CONTACT_PERSON, contactPerson).replace(QueryConstants.EMAIL, email)
				.replace(QueryConstants.VENDOR_FK, vendorFk).replace("'null'", "null").replace("''", "null");
	}

	public static String createPhoneNumberQuery(String id, String phoneExtension, String phoneNumber, String phoneType,
			String contactInfoFk) {
		return Queries.PHONE_NUMBER.replace(QueryConstants.ID, id)
				.replace(QueryConstants.PHONE_EXTENSION, phoneExtension)
				.replace(QueryConstants.PHONE_NUMBER, phoneNumber).replace(QueryConstants.PHONE_TYPE, phoneType)
				.replace(QueryConstants.CONTACT_INFO_FK, contactInfoFk).replace("'null'", "null").replace("''", "null");
	}

	public static String createAddressQuery(String id, String addressLine1, String addressLine2, String areaName,
			String cityName, String countryCode, String countryName, String stateName, String zipCode,
			String contactInfoFk) {
		return Queries.ADDRESS.replace(QueryConstants.ID, id).replace(QueryConstants.ADDRESS_LINE_1, addressLine1)
				.replace(QueryConstants.ADDRESS_LINE_2, addressLine2).replace(QueryConstants.AREA_NAME, areaName)
				.replace(QueryConstants.CITY_NAME, cityName).replace(QueryConstants.COUNTRY_CODE, countryCode)
				.replace(QueryConstants.COUNTRY_NAME, countryName).replace(QueryConstants.STATE_NAME, stateName)
				.replace(QueryConstants.ZIP_CODE, zipCode).replace(QueryConstants.CONTACT_INFO_FK, contactInfoFk)
				.replace("'null'", "null").replace("''", "null");
	}

	public static String createVendorProductQuery(String vendorId, String productId) {
		return Queries.VENDOR_PRODUCT.replace(QueryConstants.VENDOR_ID, vendorId)
				.replace(QueryConstants.PRODUCT_ID, productId).replace("'null'", "null").replace("''", "null");
	}

	public static String createProductQuery(String id, String code, String name, String description, String brand,
			String productClassification) {
		return Queries.PRODUCT.replace(QueryConstants.ID, id).replace(QueryConstants.CODE, code)
				.replace(QueryConstants.NAME, name).replace(QueryConstants.DESCRIPTION, description)
				.replace(QueryConstants.BRAND, brand)
				.replace(QueryConstants.PRODUCT_CLASSIFICATION, productClassification).replace("'null'", "null")
				.replace("''", "null");
	}

	public static String createProductAttributeQuery(String productId, String attributeId) {
		return Queries.PRODUCT_ATTRIBUTE.replace(QueryConstants.PRODUCT_ID, productId)
				.replace(QueryConstants.ATTRIBUTE_ID, attributeId).replace("'null'", "null").replace("''", "null");
	}

	public static String createGenericAttributeQuery(String id, String dtype, String code, String name,
			String description, String parentAttribute) {
		return Queries.GENERIC_ATTRIBUTE.replace(QueryConstants.ID, id).replace(QueryConstants.CODE, code)
				.replace(QueryConstants.NAME, name).replace(QueryConstants.DESCRIPTION, description)
				.replace(QueryConstants.DTYPE, dtype).replace(QueryConstants.PARENT_ATTRIBUTE, parentAttribute)
				.replace("'null'", "null").replace("''", "null");
	}

	public static String createUsersQuery(String id, String password, String username, String userAddInfoFk) {
		return Queries.USERS.replace(QueryConstants.ID, id).replace(QueryConstants.PASSWORD, password)
				.replace(QueryConstants.USERNAME, username).replace(QueryConstants.USER_ADD_INFO_FK, userAddInfoFk)
				.replace("'null'", "null").replace("''", "null");
	}

	public static String createRolesQuery(String id, String code, String description, String name) {
		return Queries.ROLES.replace(QueryConstants.ID, id).replace(QueryConstants.CODE, code)
				.replace(QueryConstants.NAME, name).replace(QueryConstants.DESCRIPTION, description)
				.replace("'null'", "null").replace("''", "null");
	}

	public static String createAuthorityQuery(String id, String code, String description, String name) {
		return Queries.AUTHORITY.replace(QueryConstants.ID, id).replace(QueryConstants.CODE, code)
				.replace(QueryConstants.NAME, name).replace(QueryConstants.DESCRIPTION, description)
				.replace("'null'", "null").replace("''", "null");
	}

	public static String createRoleAuthorityQuery(String roleId, String authorityId) {
		return Queries.ROLE_AUTHORITY.replace(QueryConstants.ROLE_ID, roleId)
				.replace(QueryConstants.AUTHORITY_ID, authorityId).replace("'null'", "null").replace("''", "null");
	}

	public static String createRoleUsersQuery(String userId, String roleId) {
		return Queries.ROLE_USERS.replace(QueryConstants.USER_ID, userId).replace(QueryConstants.ROLE_ID, roleId)
				.replace("'null'", "null").replace("''", "null");
	}

	public static String createUserAdditionalInfoQuery(String id, String firstname, String lastname,
			String profilePicLink) {
		return Queries.USER_ADDITIONAL_INFO.replace(QueryConstants.ID, id).replace(QueryConstants.FIRSTNAME, firstname)
				.replace(QueryConstants.LASTNAME, lastname).replace(QueryConstants.PROFILE_PIC_LINK, profilePicLink)
				.replace("'null'", "null").replace("''", "null");
	}

}
