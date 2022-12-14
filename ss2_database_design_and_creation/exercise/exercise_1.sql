create database if not exists chuyen_doi_erd;
use chuyen_doi_erd;

create table phieu_xuat(
  so_phieu_xuat int primary key, ngay_xuat date not null
);

create table vat_tu(
  ma_vat_tu int primary key, 
  ten_vat_tu varchar(50)
);

create table phieu_nhap(
  so_phieu_nhap int primary key, ngay_nhap date not null
);

create table don_dat_hang(
  so_don_hang int primary key, ngay_dat_hang date
);

create table nha_cung_cap(
  ma_nha_cung_cap int primary key, 
  ten_nha_cung_cap varchar(50), 
  dia_chi varchar(50), 
  so_dien_thoai varchar(20), 
  so_don_hang int, 
  foreign key (so_don_hang) references don_dat_hang(so_don_hang)
);

create table chi_tiet_phieu_xuat(
  don_gia_san_xuat double, 
  so_luong_san_xuat int, 
  so_phieu_xuat int, 
  ma_vat_tu int, 
  primary key(so_phieu_xuat, ma_vat_tu), 
  foreign key (so_phieu_xuat) references phieu_xuat(so_phieu_xuat), 
  foreign key (ma_vat_tu) references vat_tu(ma_vat_tu)
);

create table chi_tiet_phieu_nhap(
  don_gia_nhap double, 
  so_luong_nhap int, 
  ma_vat_tu int, 
  so_phieu_nhap int, 
  primary key(ma_vat_tu, so_phieu_nhap), 
  foreign key (ma_vat_tu) references vat_tu(ma_vat_tu), 
  foreign key (so_phieu_nhap) references phieu_nhap (so_phieu_nhap)
);

create table chi_tiet_don_dat_hang(
  ma_vat_tu int, 
  so_don_hang int, 
  primary key(ma_vat_tu, so_don_hang), 
  foreign key (ma_vat_tu) references vat_tu(ma_vat_tu), 
  foreign key (so_don_hang) references don_dat_hang(so_don_hang)
);
