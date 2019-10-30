package ie.adamdevenyi.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import ie.adamdevenyi.domain.Account;
import org.springframework.jdbc.core.RowMapper;

public class AccountRowMapper implements RowMapper<Account>{
		
		public Account mapRow(ResultSet rs, int rowNumber)
		throws SQLException
		{
			Account account = new Account();
			account.setAccountId(rs.getInt("accountId"));
			account.setBalance(rs.getInt("balance"));
			return account;
		}

	}