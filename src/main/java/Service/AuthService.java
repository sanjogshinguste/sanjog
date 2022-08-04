package Service;

import java.time.Instant;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.svs.jpa.Repository.UserRepository;
import com.svs.jpa.Repository.VerificationTokenRepository;
import com.svs.jpa.dto.RegisterRequest;
import com.svs.jpa.model.NotificationEmail;
import com.svs.jpa.model.User;
import com.svs.jpa.model.VerificationToken;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthService {
	

	private final PasswordEncoder encoder;
	private  final UserRepository repository;
	private final VerificationTokenRepository verificationTokenRepository;
	private final MailService mailservice;
	
	
	@Transactional
	public void signup(RegisterRequest registerRequest)
	{
		User user= new User();
		user.setUsername(registerRequest.getUserName());
		user.setEmail(registerRequest.getEmail());
		user.setPassword(encoder.encode(registerRequest.getPassword()));
		user.setCreated(Instant.now());
		user.setEnabled(false);
		
		repository.save(user);
		
		String token =generateVerificationToken(user);
		mailservice.sendMail( new NotificationEmail("please active your account",
				
				user.getEmail(),
				"body"+token
				));
		
		
				
	}
	
	private String generateVerificationToken(User user)
	{
		
		String token =UUID.randomUUID().toString();
		VerificationToken token2= new VerificationToken();
		token2.setToken(token);
		token2.setUser(user);
		verificationTokenRepository.save(token2);
		
		return token;
	}
	
	
	
	

}
