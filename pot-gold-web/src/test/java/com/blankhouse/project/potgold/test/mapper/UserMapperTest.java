package com.blankhouse.project.potgold.test.mapper;

import com.blankhouse.project.potgold.enums.UserSexEnum;
import com.blankhouse.project.potgold.mapper.UserMapper;
import com.blankhouse.project.potgold.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

	@Autowired
	private UserMapper userMapper;

	@Test
	@Transactional
	public void testInsert() throws Exception {
		userMapper.insert(new User("aa", "a123456", UserSexEnum.MAN));
		userMapper.insert(new User("bb", "b123456", UserSexEnum.WOMAN));
		userMapper.insert(new User("cc", "b123456", UserSexEnum.WOMAN));

		System.out.println(userMapper.getAll().size());
	}

	@Test
	public void testQuery() throws Exception {
		List<User> users = userMapper.getAll();
		if(users==null || users.size()==0){
			System.out.println("is null");
		}else{
			System.out.println(users.toString());
		}
	}
	
	
	@Test
	@Transactional
	public void testUpdate() throws Exception {
		User user = userMapper.getOne(2l);
		System.out.println(user.toString());
		user.setNickName("neo");
		userMapper.update(user);
		Assert.assertTrue(("neo".equals(userMapper.getOne(2l).getNickName())));
	}

}