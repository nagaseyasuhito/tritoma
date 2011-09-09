package com.github.nagaseyasuhito.tritoma.persist.dao;

import javax.persistence.NoResultException;

import com.github.nagaseyasuhito.tritoma.persist.dao.impl.UserDaoImpl;
import com.github.nagaseyasuhito.tritoma.persist.entity.User;
import com.github.nagaseyasuhito.wigpa.persist.dao.BaseDao;
import com.google.inject.ImplementedBy;

@ImplementedBy(UserDaoImpl.class)
public interface UserDao extends BaseDao<User> {

	/**
	 * {@code mailAddress}と{@code password}に合致する{@link User}を返します。
	 * 
	 * @param mailAddress
	 *            メールアドレス
	 * @param password
	 *            パスワード
	 * @return 合致した{@link User}
	 * @throws NoResultException
	 *             {@code mailAddress}もしくは{@code password}が{@code null}、もしくは合致する
	 *             {@link User}が見つからなかった場合
	 */
	User findByMailAddressAndPassword(String mailAddress, String password);
}
