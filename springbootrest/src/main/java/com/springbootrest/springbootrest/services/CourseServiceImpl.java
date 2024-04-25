package com.springbootrest.springbootrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootrest.springbootrest.dao.CourseDao;
import com.springbootrest.springbootrest.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseDao coursedao;
	
	//List<Course> list;
	
	public CourseServiceImpl() {
//		list = new ArrayList<Course>();
//		list.add(new Course(111,"Java","This is basic java course"));
//		list.add(new Course(112,"Adv Java","This is advance java course"));
		
	}

	@Override
	public List<Course> getCourses() {
		return coursedao.findAll();
		//return this.list;
	}

	@Override
	public Optional<Course> getCourse(long courseId) {
		/*Course c = null;
		for(Course course:list) {
			if(course.getId() == courseId) {
				c = course;
				break;
			}
		}
		return c;*/
		return coursedao.findById(courseId);
	}

	@Override
	public Course addCourse(Course course) {
		//list.add(course);
		coursedao.save(course);
		return course;
	}

	/*@Override
	public Course updateCourse(long courseId, Course course) {
		int i = 0;
		for(Course data : list) {
			if(data.getId() == courseId) {
				list.set(i, course);
				break;
			}
			i++;
		}
		return course;
	}*/
	
	@Override
	public Course updateCourse(Course course) {
		/*list.forEach(e -> {
			if(e.getId() == course.getId()) {
				e.setTitle(course.getTitle());
				e.setDescription(course.getDescription());
			}
		});*/
		coursedao.save(course);
		return course;
	}

	@Override
	public void deleteCourse(long courseId) {
		/*int i = 0;
		boolean deleted = false;
		for(Course data : list) {
			if(data.getId() == courseId) {
				list.remove(i);
				deleted = true;
				break;
			}
			i++;
		}
		if (deleted) {			
			return "Course id"+Long.toString(courseId)+" has been deleted";
		} else {
			return "Course id"+Long.toString(courseId)+" did not get deleted";	
		}*/
		
	   //list = this.list.stream().filter(e -> e.getId() != courseId).collect(Collectors.toList());
		
		Course c = coursedao.getOne(courseId);
		coursedao.delete(c);
	}
}
