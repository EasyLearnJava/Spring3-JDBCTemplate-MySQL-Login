package com.easylearnjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easylearnjava.dao.LoginDao;
import com.easylearnjava.exception.DaoException;
import com.easylearnjava.exception.ServiceException;

@Service
public class LoginService {

	@Autowired
	LoginDao loginDao;
	
	public boolean isValidPassword(String userName, String password) {
		try {
			String pwdFromDB = loginDao.getUserPassword(userName);

			if (null != pwdFromDB) {
				if (pwdFromDB.equals(password)) {
					return true;
				}
			}
		} catch (Exception ex) {
			if (!(ex instanceof DaoException)) {
				ex.printStackTrace();
			}			
			throw new ServiceException();
		}
		return false;
	}

}



