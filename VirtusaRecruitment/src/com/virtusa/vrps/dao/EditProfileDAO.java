package com.virtusa.vrps.dao;

import com.virtusa.vrps.model.EditProfileInfo;

public interface EditProfileDAO {

		public boolean updateProfile(EditProfileInfo edi, String nid);
}
