-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 22, 2016 at 01:32 AM
-- Server version: 5.1.41
-- PHP Version: 5.3.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `rumah_sakit`
--

-- --------------------------------------------------------

--
-- Table structure for table `dokter`
--

CREATE TABLE IF NOT EXISTS `dokter` (
  `Kode_Dokter` varchar(50) NOT NULL,
  `Nama_Dokter` varchar(50) NOT NULL,
  `Tgl_lahir` date NOT NULL,
  `Jk` varchar(50) NOT NULL,
  `Alamat` text NOT NULL,
  `Spesialis` varchar(50) NOT NULL,
  `Status` enum('Dokter Tetap','Bukan Dokter Tetap') NOT NULL,
  `No_izinK` varchar(50) NOT NULL,
  PRIMARY KEY (`Kode_Dokter`),
  KEY `fk_spe` (`Spesialis`(1))
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dokter`
--

INSERT INTO `dokter` (`Kode_Dokter`, `Nama_Dokter`, `Tgl_lahir`, `Jk`, `Alamat`, `Spesialis`, `Status`, `No_izinK`) VALUES
('DR001', 'Wicaksono', '1975-05-14', 'Laki-laki', 'Bandung', 'Dokter Bagian Dalam', 'Dokter Tetap', '051475051399'),
('DR002', 'Disa Ratna Nurhasanah', '1990-04-22', 'Perempuan', 'Bandung', 'Dokter Gigi', 'Dokter Tetap', '042290100023'),
('DR003', 'Ahmad Nurdin', '1982-12-08', 'Laki-laki', 'Bandung', 'Dokter Anak', 'Dokter Tetap', '12088210034'),
('DR004', 'Ridwan Guntara', '1980-02-02', 'Laki-laki', 'Bandung', 'Dokter Anak', 'Dokter Tetap', '020280020302'),
('DR005', 'Sofian Alghifari', '1985-09-09', 'Laki-laki', 'Cinunuk', 'Dokter THT', 'Dokter Tetap', '10098510101301'),
('DR006', 'Boy Agustian', '1985-08-15', 'Laki-laki', 'Cibiru', 'Dokter Kandungan', 'Dokter Tetap', '081585081113'),
('DR007', 'Rini Gustiani', '1987-03-10', 'Perempuan', 'Buah Batu', 'Dokter Mata', 'Dokter Tetap', '03108703111608'),
('DR008', 'Desi Setiani', '1978-12-20', 'Perempuan', 'Panyileukan', 'Dokter Umum', 'Dokter Tetap', '122078201503'),
('DR009', 'Dinda Febrianita Anggraeni', '1993-02-25', 'Perempuan', 'Bandung', 'Dokter Anak', 'Bukan Dokter Tetap', '022593022716'),
('DR010', 'Yati Isnaini', '1970-10-23', 'Perempuan', 'Jl. Jakarta', 'Dokter Gigi', 'Dokter Tetap', '102370101193');

-- --------------------------------------------------------

--
-- Table structure for table `jadwal`
--

CREATE TABLE IF NOT EXISTS `jadwal` (
  `Kode_jadwal` varchar(50) NOT NULL,
  `Kode_ruangan` varchar(50) NOT NULL,
  `Nama_klinik` varchar(50) NOT NULL,
  `Hari` varchar(50) NOT NULL,
  `Waktu` varchar(50) NOT NULL,
  `Kdokter` varchar(50) NOT NULL,
  `Ndokter` varchar(50) NOT NULL,
  PRIMARY KEY (`Kode_jadwal`),
  KEY `fk_dok` (`Kdokter`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jadwal`
--

INSERT INTO `jadwal` (`Kode_jadwal`, `Kode_ruangan`, `Nama_klinik`, `Hari`, `Waktu`, `Kdokter`, `Ndokter`) VALUES
('JD01', 'R402', 'Klinik Anak', 'Senin & Rabu', '08.00 - 15.30', 'DR003', 'Ahmad Nurdin'),
('JD02', 'R401', 'Klinik Gigi', 'Selasa, Rabu & Jumat', '08.30 - 14.30', 'DR002', 'Disa Ratna Nurhasanah'),
('JD03', 'R406', 'Klinik Bagian Dalam', 'Senin - Jumat', '08.00 - 14.30', 'DR001', 'Wicaksono'),
('JD04', 'R402', 'Klinik Anak', 'Rabu & Jumat', '08.00 - 16.00', 'DR004', 'Ridwan Guntara'),
('JD05', 'R404', 'Klinik THT', 'Senin - Kamis', '08.30 - 14.30', 'DR005', 'Sofian Alghifari'),
('JD06', 'R405', 'Klinik Kandungan', 'Selasa - Rabu', '08.00 - 16.00', 'DR006', 'Boy Agustian'),
('JD07', 'R403', 'Klinik Mata', 'Senin - Kamis', '08.30 - 15.00', 'DR007', 'Rini Gustiani'),
('JD08', 'R407', 'Klinik Umum', 'Senin - Jumat', '07.30 - 15.30', 'DR008', 'Desi Setiani'),
('JD09', 'R402', 'Klinik Anak', 'Selasa, Rabu & Jumat', '08.00 - 15.30', 'DR009', 'Dinda Febrianita Anggraeni'),
('JD10', 'R401', 'Klinik Gigi', 'Senin - Kamis', '08.00 - 15.30', 'DR010', 'Yati Isnaini');

-- --------------------------------------------------------

--
-- Table structure for table `kelas_perawatan`
--

CREATE TABLE IF NOT EXISTS `kelas_perawatan` (
  `Kode_kelas` varchar(50) NOT NULL,
  `Harga_bayar` int(11) DEFAULT NULL,
  PRIMARY KEY (`Kode_kelas`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kelas_perawatan`
--

INSERT INTO `kelas_perawatan` (`Kode_kelas`, `Harga_bayar`) VALUES
('1', 59500),
('2', 42500),
('3', 25500);

-- --------------------------------------------------------

--
-- Table structure for table `pasien`
--

CREATE TABLE IF NOT EXISTS `pasien` (
  `Kode_pas` varchar(50) NOT NULL,
  `No_KTP` varchar(50) NOT NULL,
  `Nama_Pasien` varchar(50) NOT NULL,
  `Ttl` date NOT NULL,
  `Golongan_Darah` enum('A','B','O','AB') NOT NULL,
  `Alamat` text NOT NULL,
  `Jk` varchar(50) NOT NULL,
  `Pekerjaan` varchar(50) NOT NULL,
  `Bagian_Perawatan` varchar(50) NOT NULL,
  PRIMARY KEY (`Kode_pas`),
  KEY `fk_rawat` (`Bagian_Perawatan`(1))
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pasien`
--

INSERT INTO `pasien` (`Kode_pas`, `No_KTP`, `Nama_Pasien`, `Ttl`, `Golongan_Darah`, `Alamat`, `Jk`, `Pekerjaan`, `Bagian_Perawatan`) VALUES
('PAT001', '3204072112950001', 'Raka Fajar Salinggih', '1995-12-21', 'O', 'Bandung', 'Laki-laki', 'Pelajar/Mahasiswa', 'Dokter Gigi'),
('PAT002', '320623050565004', 'Pairin', '1965-05-05', 'A', 'Bandung', 'Laki-laki', 'Wirausaha', 'Dokter Bagian Dalam'),
('PAT003', '321010230960021', 'Rizki Fauzan Adzim', '1996-02-23', 'A', 'Leuwimunding', 'Laki-laki', 'Pelajar/Mahasiswa', 'Dokter THT'),
('PAT004', '3212121205930002', 'Billy Alvian Permata', '1993-05-12', 'AB', 'Bandung', 'Laki-laki', 'Pelajar/Mahasiswa', 'Dokter Umum'),
('PAT005', '3213023103960002', 'M. Sofwan Fauzan', '1996-03-31', 'AB', 'Cipadung', 'Laki-laki', 'Pelajar/Mahasiswa', 'Dokter Gigi'),
('PAT006', '3273257101980001', 'Dinda Jihan ', '1998-01-31', 'B', 'Cipadung', 'Perempuan', 'Guru', 'Dokter Kandungan'),
('PAT007', '3204120709950001', 'Rizky Sam Pratama', '1995-09-07', 'A', 'Cicaheum', 'Laki-laki', 'Pelajar/Mahasiswa', 'Dokter Mata'),
('PAT008', '3204054701700002', 'Siti Rosidah', '1970-01-07', 'AB', 'Cinunuk', 'Perempuan', 'Ibu Rumah Tangga', 'Dokter Bagian Dalam'),
('PAT009', '3204122104900007', 'Eko Apriyanto', '1990-05-04', 'B', 'Dayeuhkolot', 'Laki-laki', 'Wiraswasta', 'Dokter Umum'),
('PAT010', '320413700492004', 'Edis Hilvia Roziah', '1992-04-30', 'A', 'Banjaran', 'Perempuan', 'Lain-lain', 'Dokter Gigi'),
('PAT011', '3173052007960002', 'Tri Yulianto', '1996-07-20', 'A', 'Jl. Manisi', 'Laki-laki', 'Pelajar/Mahasiswa', 'Dokter Umum');

-- --------------------------------------------------------

--
-- Table structure for table `pekerjaan`
--

CREATE TABLE IF NOT EXISTS `pekerjaan` (
  `Kode_pekerjaan` varchar(50) NOT NULL,
  `Nama_pekerjaan` varchar(50) NOT NULL,
  PRIMARY KEY (`Kode_pekerjaan`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pekerjaan`
--

INSERT INTO `pekerjaan` (`Kode_pekerjaan`, `Nama_pekerjaan`) VALUES
('WRK001', 'Guru'),
('WRK002', 'Pegawai Negeri'),
('WRK003', 'TNI/POLRI'),
('WRK004', 'Wirausaha'),
('WRK005', 'Wiraswasta'),
('WRK006', 'Pelajar/Mahasiswa'),
('WRK007', 'Pensiunan'),
('WRK008', 'Petani'),
('WRK009', 'Ibu Rumah Tangga'),
('WRK010', 'Lain-lain');

-- --------------------------------------------------------

--
-- Table structure for table `peserta_bpjs`
--

CREATE TABLE IF NOT EXISTS `peserta_bpjs` (
  `No_Regis` varchar(20) NOT NULL,
  `Nik` varchar(20) NOT NULL,
  `Nama_peserta` varchar(50) NOT NULL,
  `Jk` varchar(20) NOT NULL,
  `Tempat_L` varchar(20) NOT NULL,
  `Tgl_lahir` date NOT NULL,
  `Alamat` text NOT NULL,
  `Status_per` varchar(50) NOT NULL,
  `No_hp` varchar(50) NOT NULL,
  `Pekerjaan` varchar(50) NOT NULL,
  `npwp` int(15) NOT NULL,
  `Kelas_P` varchar(50) NOT NULL,
  PRIMARY KEY (`No_Regis`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `peserta_bpjs`
--

INSERT INTO `peserta_bpjs` (`No_Regis`, `Nik`, `Nama_peserta`, `Jk`, `Tempat_L`, `Tgl_lahir`, `Alamat`, `Status_per`, `No_hp`, `Pekerjaan`, `npwp`, `Kelas_P`) VALUES
('BPJS001', '3273250106960001', 'Viqi Nurhaqiqi', 'Laki-laki', 'Bandung', '1996-06-01', 'Bandung', 'Belum Kawin', '085861940810', 'Wiraswasta', 2700000, '2'),
('BPJS002', '3273255005580002', 'Tatie Nurhayati', 'Perempuan', 'Bandung', '1958-05-10', 'Bandung', 'Kawin', '081220134010', 'Guru', 3500000, '2'),
('BPJS003', '3204051202610003', 'Damanhuri', 'Laki-laki', 'Blitar', '1961-02-12', 'Cipondoh', 'Kawin', '081220780456', 'TNI/POLRI', 5000000, '1'),
('BPJS004', '3273256308960005', 'Tia Gustini', 'Perempuan', 'Bandung', '1996-08-23', 'Bandung', 'Belum Kawin', '085729876120', 'Wirausaha', 3500000, '2'),
('BPJS005', '3213142007950005', 'Fikar Arsyad A', 'Perempuan', 'Bandung', '1995-07-20', 'Tanjungsiang', 'Belum Kawin', '081322886779', 'TNI/POLRI', 3500000, '2'),
('BPJS006', '3217010604890002', 'Dadan Nurjaman', 'Laki-laki', 'Bandung', '1989-04-05', 'Lembang', 'Belum Kawin', '089899200301', 'Wiraswasta', 1850000, '3'),
('BPJS007', '3273242302880001', 'Romy Pujarama Nugraha', 'Laki-laki', 'Bandung', '1988-02-23', 'Arcamanik', 'Belum Kawin', '082290345670', 'Wiraswasta', 2500000, '2');

-- --------------------------------------------------------

--
-- Table structure for table `petugas_admin`
--

CREATE TABLE IF NOT EXISTS `petugas_admin` (
  `Kode_adm` varchar(8) NOT NULL,
  `Username` varchar(10) NOT NULL,
  `Password` varchar(16) NOT NULL,
  PRIMARY KEY (`Kode_adm`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `petugas_admin`
--

INSERT INTO `petugas_admin` (`Kode_adm`, `Username`, `Password`) VALUES
('ADM01', 'admin01', 'adminsatu'),
('ADM02', 'admin02', 'admindua');

-- --------------------------------------------------------

--
-- Table structure for table `ruangan`
--

CREATE TABLE IF NOT EXISTS `ruangan` (
  `Kode_ruangan` varchar(50) NOT NULL,
  `Nama_ruangan` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Kode_ruangan`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ruangan`
--

INSERT INTO `ruangan` (`Kode_ruangan`, `Nama_ruangan`) VALUES
('R401', 'Klinik Gigi'),
('R402', 'Klinik Anak'),
('R403', 'Klinik Mata'),
('R404', 'Klinik THT'),
('R405', 'Klinik Kandungan'),
('R406', 'Klinik Bagian Dalam'),
('R407', 'Klinik Umum');

-- --------------------------------------------------------

--
-- Table structure for table `spesialis`
--

CREATE TABLE IF NOT EXISTS `spesialis` (
  `Kode_spe` varchar(50) NOT NULL,
  `Nama_spe` varchar(50) NOT NULL,
  PRIMARY KEY (`Kode_spe`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `spesialis`
--

INSERT INTO `spesialis` (`Kode_spe`, `Nama_spe`) VALUES
('SP001', 'Dokter Anak'),
('SP002', 'Dokter Bagian Dalam'),
('SP003', 'Dokter Gigi'),
('SP004', 'Dokter Kandungan'),
('SP005', 'Dokter Mata'),
('SP006', 'Dokter Umum'),
('SP007', 'Dokter THT');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
