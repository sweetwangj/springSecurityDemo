package com.operation.qkwall.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


import com.operation.qkwall.entity.Admin;
import com.operation.qkwall.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
	@Autowired
	private AdminMapper adminMapper;


	/**
	 * 保存用户
	 * 
	 * @param admin
	 */
	public void save(Admin admin) {
	 BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		if (admin.getRole() == "0") {
			admin.setRole("ROLE_ADMIN");
		} else {
			admin.setRole("ROLE_USER");
		}
		admin.setPassword(passwordEncoder.encode(admin.getPassword()));
		adminMapper.insert(admin);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Admin admin = adminMapper.findUserByName(username);
		if (admin == null || admin.equals("")) {
			throw new UsernameNotFoundException(username + " not found");
		}
		System.err.println(admin.getRole() + "正在执行查询角色名称");
		return new UserDetails() {
			private static final long serialVersionUID = 3720901165271071386L;
			@Override
			public Collection<? extends GrantedAuthority> getAuthorities() {
				List<SimpleGrantedAuthority> auths = new ArrayList<>();
				auths.add(new SimpleGrantedAuthority(admin.getRole()));
				return auths;
			}

			@Override
			public String getPassword() {
				return admin.getPassword();
			}

			@Override
			public String getUsername() {
				return username;
			}

			@Override
			public boolean isAccountNonExpired() {
				return true;
			}

			@Override
			public boolean isAccountNonLocked() {
				return true;
			}

			@Override
			public boolean isCredentialsNonExpired() {
				return true;
			}

			@Override
			public boolean isEnabled() {
				return true;
			}
		};
	}
	
	public Admin getUserByname(String username) {
		return adminMapper.findUserByName(username);
	}
	public List<Admin> getAdminList() {
		return adminMapper.select();
	}

}
