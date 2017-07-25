package web.service;

import java.util.List;

import web.entity.User;
import web.exception.NameRepeatException;

public interface UserService {
	public void addUser(User user) throws NameRepeatException;;// ע��

	public boolean login(User user);// ��¼

	public boolean checkUser(String name);// ע��ʱ����������ѯ�Ƿ��ظ�

	public List<User> findAll();// ��ѯ�û���Ϣ

	public void updateUser(User user);// �޸��û�

	public void deleteUser(String id);// ɾ���û�
	
	public User findById(String id);// ���ݱ�Ų�ѯ�û�
}
