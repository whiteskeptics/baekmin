package com.project.bustaja.notice.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.project.bustaja.terminal.dao.TerminalVO;

@Repository
public class NoticeDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public void insertNotice(NoticeVO vo) {
		String sql = "insert into notice values((select nvl(max(seq),0)+1 from notice), ?, ?, ?, sysdate, 0)";
		jdbcTemplate.update(sql, vo.getTitle(), vo.getWriter(), vo.getNcontents());
	}

	public List<NoticeVO> listNotice(int page, int limit) {
		List<NoticeVO> result = null;
		String sql = "select * from (select rownum as listNum, imsi.* from (( select * from notice) imsi)) where listNum >= ? and listNum <= ?";
		Object[] args = { page, limit };
		result = jdbcTemplate.query(sql, args, new NoticeRowMapper());
		return result;
	}

	public NoticeVO getNotice(NoticeVO vo) {
		String sql = "select * from notice where seq = ?";
		Object[] args = {vo.getSeq()};
		getCount();
		return jdbcTemplate.queryForObject(sql, args, new NoticeRowMapper());
	}

	public void delNotice(int seq) {
		String sql = "delete from notice where seq = ?";
		jdbcTemplate.update(sql, seq);
	}

	
	public void updateNotice(NoticeVO vo) { 
		String sql = "update notice set title=?, ncontents=? where seq=?";
		jdbcTemplate.update(sql, vo.getTitle(), vo.getNcontents(), vo.getSeq()); 
	}
	 
	public int getCount() {
		String sql = "select count(*) from notice";
		return jdbcTemplate.queryForInt(sql);
	}
	public NoticeVO getNotice(int seq) {
		String sql = "select * from notice where seq = ?";
		Object[] args = {seq};
		getCount();
		return jdbcTemplate.queryForObject(sql, args, new NoticeRowMapper());
	}

}
