package info.thecodinglive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;

import info.thecodinglive.model.FreeBoardVO;
import info.thecodinglive.repository.FreeBoardRepository;

@SpringBootApplication(exclude = WebMvcAutoConfiguration.class)
public class FreeBoardApp implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(FreeBoardApp.class, args);
	}
	
	@Autowired
	FreeBoardRepository freeBoardRepository;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("freeboard run");
		FreeBoardVO vo = new FreeBoardVO();
		vo.setUserName("홍길동");
		vo.setCategory("101");
		vo.setContent("자유게시판 첫 글");
		vo.setTitle("안녕");
		
		freeBoardRepository.registBoard(vo);
	}
	
}
