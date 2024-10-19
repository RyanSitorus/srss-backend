package com.srss.backend.entity;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "dokter")
@AllArgsConstructor
public class Doctor {

	@Id
	@Column(name = "id_dokter", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDokter;

	@Column(name = "nomor_dokter", nullable = false)
	private String nomorDokter;

	@Column(name = "nama_dokter", nullable = false)
	private String namaDokter;

	@Column(name = "nomor_hp")
	private String nomorHp;

	@Column(name = "tanggal_lahir")
	private LocalDate tanggalLahir;

	@Column(name = "jenis_kelamin")
	private String jenisKelamin;

	@Column(name = "spesialis")
	private String spesialis;

	@Column(name = "alamat")
	private String alamat;

	public Doctor() {
	}

	public Long getIdDokter() {
		return idDokter;
	}

	public void setIdDokter(Long idDokter) {
		this.idDokter = idDokter;
	}

	public String getNomorDokter() {
		return nomorDokter;
	}

	public void setNomorDokter(String nomorDokter) {
		this.nomorDokter = nomorDokter;
	}

	public String getNamaDokter() {
		return namaDokter;
	}

	public void setNamaDokter(String namaDokter) {
		this.namaDokter = namaDokter;
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

	public String getSpesialis() {
		return spesialis;
	}

	public void setSpesialis(String spesialis) {
		this.spesialis = spesialis;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

}
