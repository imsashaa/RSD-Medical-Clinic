-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 15 Jun 2020 pada 11.03
-- Versi Server: 10.1.13-MariaDB
-- PHP Version: 7.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `clinic`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `mitra`
--

CREATE TABLE `mitra` (
  `id_mitra` int(11) NOT NULL,
  `nama_perusahaan` varchar(50) NOT NULL,
  `id_pegawai` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `mitra`
--

INSERT INTO `mitra` (`id_mitra`, `nama_perusahaan`, `id_pegawai`) VALUES
(1, 'THIESS', 'T0001'),
(2, 'THIESS', 'T0006'),
(3, 'THIESS', 'T0002'),
(4, 'THIESS', 'T0003'),
(5, 'THIESS', 'T0004'),
(6, 'THIESS', 'T0005'),
(7, 'KPC', 'KPC001'),
(8, 'KPC', 'KPC002'),
(9, 'KPC', 'KPC003'),
(10, 'KPC', 'KPC004'),
(11, 'KPC', 'KPC005'),
(12, 'KPC', 'KPC006'),
(13, 'HEXAGON', 'HEXA001'),
(14, 'HEXAGON', 'HEXA002'),
(15, 'HEXAGON', 'HEXA003'),
(16, 'HEXAGON', 'HEXA004'),
(17, 'HEXAGON', 'HEXA005'),
(18, 'HEXAGON', 'HEXA006');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pasien`
--

CREATE TABLE `pasien` (
  `no_rj` int(11) NOT NULL,
  `nik` varchar(20) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `tempat_lahir` varchar(50) NOT NULL,
  `tanggal_lahir` date NOT NULL,
  `umur` int(3) NOT NULL,
  `jenis_kelamin` enum('Laki-laki','Perempuan') NOT NULL,
  `alamat` text NOT NULL,
  `telepon` varchar(20) NOT NULL,
  `pekerjaan` varchar(50) NOT NULL,
  `agama` varchar(50) NOT NULL,
  `poli` enum('Poli Umum','Poli Anak','Poli THT','Poli Kandungan','Poli Gigi') NOT NULL,
  `no_rujukan` varchar(20) DEFAULT NULL,
  `asal_rujukan` varchar(50) DEFAULT NULL,
  `diagnosa` text,
  `keterangan` text,
  `status_pembayaran` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `pasien`
--

INSERT INTO `pasien` (`no_rj`, `nik`, `nama`, `tempat_lahir`, `tanggal_lahir`, `umur`, `jenis_kelamin`, `alamat`, `telepon`, `pekerjaan`, `agama`, `poli`, `no_rujukan`, `asal_rujukan`, `diagnosa`, `keterangan`, `status_pembayaran`) VALUES
(1, '123', 'Rahmat Zidane', 'Samarinda', '2000-01-21', 20, 'Laki-laki', 'Jalan Kadrie Oening', '082156466638', 'Mahasiswa', 'Islam', 'Poli Umum', NULL, NULL, 'Sehat', 'Banget', 'Sudah Bayar'),
(2, '321', 'Shafa Innocentia', 'Bontang', '2020-06-05', 21, 'Perempuan', 'Jalan Juanda', '08225646377', 'Swasta', 'Islam', 'Poli Kandungan', '222', 'Samarinda', 'sehat', 'aman', 'Sudah Bayar'),
(3, '456', 'Febrina Wahyu', 'Balikpapan', '2020-06-13', 22, 'Perempuan', 'Jalan Palaran', '08234552141', 'Wiraswasta', 'Islam', 'Poli Gigi', NULL, NULL, 'sehat banget', 'siap aman', 'Sudah Bayar');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pembayaran`
--

CREATE TABLE `pembayaran` (
  `no_pembayaran` int(11) NOT NULL,
  `no_rj` int(11) NOT NULL,
  `no_bpjs` varchar(15) DEFAULT NULL,
  `id_mitra` int(11) DEFAULT NULL,
  `total_bayar` int(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `pembayaran`
--

INSERT INTO `pembayaran` (`no_pembayaran`, `no_rj`, `no_bpjs`, `id_mitra`, `total_bayar`) VALUES
(1, 1, NULL, NULL, 30000),
(2, 1, NULL, NULL, 30000),
(3, 1, NULL, NULL, 30000),
(4, 2, '999', NULL, 142100),
(5, 3, NULL, 17, 25000);

--
-- Trigger `pembayaran`
--
DELIMITER $$
CREATE TRIGGER `UbahStatus` AFTER INSERT ON `pembayaran` FOR EACH ROW BEGIN
UPDATE pasien SET pasien.status_pembayaran = 'Sudah Bayar' WHERE pasien.no_rj = new.no_rj;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `pembelian`
--

CREATE TABLE `pembelian` (
  `no_pembelian` int(11) NOT NULL,
  `item` varchar(50) NOT NULL,
  `harga` int(12) NOT NULL,
  `no_rj` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `pembelian`
--

INSERT INTO `pembelian` (`no_pembelian`, `item`, `harga`, `no_rj`) VALUES
(3, 'antimo', 10000, 1),
(4, 'migran', 20000, 1),
(5, 'pusing', 1000, 2),
(6, 'konsul', 200000, 2),
(7, 'obat', 2000, 2),
(8, 'konsultasi', 20000, 3),
(9, 'betadine', 5000, 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `mitra`
--
ALTER TABLE `mitra`
  ADD PRIMARY KEY (`id_mitra`);

--
-- Indexes for table `pasien`
--
ALTER TABLE `pasien`
  ADD PRIMARY KEY (`no_rj`);

--
-- Indexes for table `pembayaran`
--
ALTER TABLE `pembayaran`
  ADD PRIMARY KEY (`no_pembayaran`),
  ADD KEY `no_rj` (`no_rj`),
  ADD KEY `id_mitra` (`id_mitra`);

--
-- Indexes for table `pembelian`
--
ALTER TABLE `pembelian`
  ADD PRIMARY KEY (`no_pembelian`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `mitra`
--
ALTER TABLE `mitra`
  MODIFY `id_mitra` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
--
-- AUTO_INCREMENT for table `pasien`
--
ALTER TABLE `pasien`
  MODIFY `no_rj` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `pembayaran`
--
ALTER TABLE `pembayaran`
  MODIFY `no_pembayaran` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `pembelian`
--
ALTER TABLE `pembelian`
  MODIFY `no_pembelian` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `pembayaran`
--
ALTER TABLE `pembayaran`
  ADD CONSTRAINT `id_mitra` FOREIGN KEY (`id_mitra`) REFERENCES `mitra` (`id_mitra`) ON DELETE SET NULL ON UPDATE SET NULL,
  ADD CONSTRAINT `no_rj` FOREIGN KEY (`no_rj`) REFERENCES `pasien` (`no_rj`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
