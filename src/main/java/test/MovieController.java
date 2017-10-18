package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieController {
  @Autowired
  private RestTemplate restTemplate;

  @GetMapping("/user/{id}")
  public User findById(@PathVariable Long id) {
	//只要给  restTemplate 加了负载均衡注解，就可以用虚拟主机服务名，不用具体IP地址
    return this.restTemplate.getForObject("http://microservice-provider-user-jzq/" + id, User.class);
  }
}
