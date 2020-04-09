package it.itsrizzoli.Spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.Data;

@Controller
public class HelloController {
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;

	@GetMapping("/")
	String hello() {
		return "Hello World!";
	}

	@Data
	static class Result {
		
		public Result(int left2, int right2, long long1) {
			this.left = left2;
			this.right = right2;
			this.answer = long1;
		}
		
		private final int left;
		private final int right;
		private final long answer;
	}

	// SQL sample
	@RequestMapping("calc")
	Result calc(@RequestParam int left, @RequestParam int right) {
		MapSqlParameterSource source = new MapSqlParameterSource().addValue("left", left).addValue("right", right);
		return jdbcTemplate.queryForObject("SELECT :left + :right AS answer", source,
				(rs, rowNum) -> new Result(left, right, rs.getLong("answer")));
	}
}