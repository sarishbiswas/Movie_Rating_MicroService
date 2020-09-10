package com.sarish.moviecatalogservice.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name="userDetails")
public class UserDetails {
	@Id
	private int userId;
	@Column(name="userName")
	private String userName;
	@Column(name="userEmail")
	private String userEmail;
}
