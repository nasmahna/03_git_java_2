public class FormDepresiasi extends javax.swing.JFrame {
    StringBuilder sb;
    int harga;
    int nilai;
    int umur;
    int awal;
    int akhir;

    /**
     * Creates new form FormDepresiasi
     */
    public FormDepresiasi() {
        initComponents();
        
        sb = new StringBuilder();
    }
    
    
    public void loadHasilPerhitungan() throws HargaTidakBolehKosong, NilaiTidakBolehKosong, UmurTidakBolehKosong, 
            TahunAwalTidakBolehKosong, TahunAkhirTidakBolehKosong{
        
        try {
            harga = Integer.parseInt(txtHargaPerolehan.getText());
        } catch (NumberFormatException e) {
            throw new HargaTidakBolehKosong();
        } try {
            nilai = Integer.parseInt(txtNilaiResidu.getText());
        } catch (NumberFormatException e) {
            throw new UmurTidakBolehKosong();
        } try {
            umur = Integer.parseInt(txtUmurEkonomis.getText());
        } catch (NumberFormatException e) {
            throw new UmurTidakBolehKosong();
        } try {
            awal = Integer.parseInt(txtTahunAwal.getText());
        } catch (NumberFormatException e) {
            throw new TahunAwalTidakBolehKosong();
        } try {
            akhir = Integer.parseInt(txtTahunAkhir.getText());
        } catch (NumberFormatException e) {
            throw new TahunAkhirTidakBolehKosong();
        }
        
        if (harga != 0 && umur != 0 && awal != 0 && akhir != 0 && nilai != 0){
            if (awal < akhir){
                double penyusutan = (harga - nilai) / umur;
                    for (umur = awal; umur <= akhir; umur++){
                        System.out.println(umur);
                        double akm = (umur * penyusutan);
                        double sisa = (harga - akm);
                        String result = String.format("%d %d\t%f\t%f", umur, harga, akm, sisa);
                        taHasil.setText("Tahun\tHarga\tAkumulasi\tNilai");
                        taHasil.setText(result);
                    }
            } else {
                taHasil.setText("False");
            }
        } else {
            taHasil.setText("Stop!");
        }

    }
    
    public void Reset() {
        txtHargaPerolehan.setText(null);
        txtNilaiResidu.setText(null);
        txtUmurEkonomis.setText(null);
        txtTahunAwal.setText(null);
        txtTahunAkhir.setText(null);
        taHasil.setText(null);
    }
    
    private void bttnHitungMouseClicked(java.awt.event.MouseEvent evt) {                                        
        // TODO add your handling code here:
        try 
        {
            this.loadHasilPerhitungan();
        } catch (HargaTidakBolehKosong e) 
        {
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (UmurTidakBolehKosong e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (NilaiTidakBolehKosong e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (TahunAwalTidakBolehKosong e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (TahunAkhirTidakBolehKosong e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
      
        
    }                                       


    private void bttnResetMouseClicked(java.awt.event.MouseEvent evt) {                                       
        // TODO add your handling code here:
        this.Reset();
    }   
