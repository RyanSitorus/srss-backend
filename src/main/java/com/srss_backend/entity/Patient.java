package com.srss_backend.entity;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Entity
@Table(name = "pasien")
public class Patient {

	@Id
	@Column(name = "id_pasien", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPasien;

	@Column(name = "nomor_pasien", nullable = false)
	private String nomorPasien;

	@Column(name = "nama_pasien", nullable = false)
	private String namaPasien;

	@Column(name = "nomor_hp")
	private String nomorHp;

	@Column(name = "tanggal_lahir")
	private LocalDate tanggalLahir;

	@Column(name = "jenis_kelamin")
	private String jenisKelamin;

	@Column(name = "kategori")
	private String kategori;

	@Column(name = "alamat")
	private String alamat;

	public Patient() {
	}

	public Long getIdPasien() {
		return idPasien;
	}

	public void setIdPasien(Long idPasien) {
		this.idPasien = idPasien;
	}

	public String getNomorPasien() {
		return nomorPasien;
	}

	public void setNomorPasien(String nomorPasien) {
		this.nomorPasien = nomorPasien;
	}

	public String getNamaPasien() {
		return namaPasien;
	}

	public void setNamaPasien(String namaPasien) {
		this.namaPasien = namaPasien;
	}

	public String getNomorHp() {
		return nomorHp;
	}

	public void setNomorHp(String nomorHp) {
		this.nomorHp = nomorHp;
	}

	public LocalDate getTanggalLahir() {
		return tanggalLahir;
	}

	public void setTanggalLahir(LocalDate tanggalLahir) {
		this.tanggalLahir = tanggalLahir;
	}

	public String getJenisKelamin() {
		return jenisKelamin;
	}

	public void setJenisKelamin(String jenisKelamin) {
		this.jenisKelamin = jenisKelamin;
	}

	public String getKategori() {
		return kategori;
	}

	public void setKategori(String kategori) {
		this.kategori = kategori;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

}
