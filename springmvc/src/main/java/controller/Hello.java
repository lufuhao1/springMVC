package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import mapper.UserMapper;

@Controller
public class Hello {
	@Autowired
	private UserMapper userMapper;

	@GetMapping("/test.do")
	@ResponseBody
	public List<Map<String, Object>> test() {
		List<Map<String, Object>> result = userMapper.selectAll();
		System.out.println(result);
		return result;
	}

	@PostMapping("/userLogin.do")
	@ResponseBody
	public Map<String, Object> login(
			@RequestParam(value = "account", defaultValue = "") String account,
			@RequestParam(value = "password", defaultValue = "") String password) {
		password = DigestUtils.md5Hex(password);
		System.out.println(password);
		Map<String, Object> result = userMapper.login(account, password);
		/* result.put("message", "OK"); */
		/*
		 * result.put("message", "ERROR"); result.put("error",
		 * "INVALID_ACCOUNT_OR_PASSWORD");
		 */
		System.out.println(result);
		return result;
	}

	/*
	 * @PostMapping("/login.do") public String login(
	 * 
	 * @RequestParam(value = "account", defaultValue = "") String account,
	 * 
	 * @RequestParam(value = "password", defaultValue = "") String password ) {
	 * System.out.println(account); password = DigestUtils.md5Hex(password);
	 * System.out.println(password); Map<String, Object> map =
	 * userMapper.login(account, password); System.out.println(map); return
	 * "index"; }
	 */

	@GetMapping("/guanli.do")
	public String guanli(Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("msg", "111");
		map.put("status", "12312313");
		List<Map> list = new ArrayList<Map>();
		list.add(map);
		// map.clear();
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("msg", "13dads");
		map1.put("status", "asde24r0ijf");
		list.add(map1);
		System.out.println(list);
		model.addAttribute("list", list);
		return "index";
	}
}
