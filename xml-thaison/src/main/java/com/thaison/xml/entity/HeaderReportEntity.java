package com.thaison.xml.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.thaison.xml.entity.BaseEntityJpa;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(schema = "public", name = "HEADER_REPORT")
public class HeaderReportEntity extends BaseEntityJpa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "APP")
	private String app;

	@Column(name = "DB_VERSION")
	private String dbVersion;

	@Column(name = "LAST_UPDATE")
	private LocalDateTime lastUpdate;

	@Column(name = "VERSION_MESSAGE")
	private String versionMessage;

	@Column(name = "DATE")
	private LocalDateTime date;

}
