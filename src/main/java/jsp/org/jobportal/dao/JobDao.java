package jsp.org.jobportal.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties.Job;
import org.springframework.stereotype.Repository;

import jsp.org.jobportal.repository.JobRepository;

@Repository
public class JobDao {

	@Autowired
	JobRepository jobRepository;

	public List<Job> viewAllJobs() {
		return jobRepository.findByLastDateAfter(LocalDate.now());
	}

	public Job findById(int id) {
		return jobRepository.findById(id).orElse(null);
	}

	public void saveJob(Job job) {
		jobRepository.save(job);
	}
}