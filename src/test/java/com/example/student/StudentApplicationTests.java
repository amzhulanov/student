package com.example.student;

import com.example.student.dao.StudentDAO;
import com.example.student.entities.Student;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Random;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class StudentApplicationTests {

	private StudentDAO studentDao;

	@Autowired
	StudentApplicationTests(StudentDAO studentDao) {
		this.studentDao = studentDao;
	}

	@Before
	void saveNewData() {
		for (int i = 0; i < 1000; i++) {
			Student student=new Student(generateName(), generateMark());
			studentDao.save(student);
		}

	}
	@Test
	void studentDAOFindByIdTest(){
		Student student;
		student=studentDao.findById((long) 2);
		Assert.notNull(studentDao.findById((long) 2));
	}

	@Test
	void studentDAODeleteByIdTest(){
		studentDao.deleteById((long)10);
		Assert.isNull(studentDao.findById((long) 10));
	}

	@Test
	void studentDAOFindAll(){
		List<Student> students;
		students=studentDao.findAll();
		Assert.notEmpty(students);
	}

	@Test
	void setStudentDaoFindById(){
		Assert.notNull(studentDao.findById((long) 23));
	}
	
	private String generateName(){
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 10;
		Random random = new Random();
		StringBuilder buffer = new StringBuilder(targetStringLength);
		for (int i = 0; i < targetStringLength; i++) {
			int randomLimitedInt = leftLimit + (int)
					(random.nextFloat() * (rightLimit - leftLimit + 1));
			buffer.append((char) randomLimitedInt);
		}
		return (buffer.toString());
	}
	
	private Integer generateMark(){
		return new Random().nextInt(10);
	}
	

}
