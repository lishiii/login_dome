package web.dao;

import java.util.List;
import java.util.UUID;

import web.entity.User;

public interface UserDao {
	public void addUser(User user);// ע��
	public boolean login(User user);// ��¼
	public boolean checkUser(String name);// ע��ʱ����������ѯ�Ƿ��ظ�
	public List<User> findAll();// ��ѯ�û���Ϣ
	public void updateUser(User user);// �޸��û�
	public void deleteUser(String id);// ɾ���û�
	public User findById(String id);// ���ݱ�Ų�ѯ�û�
}
