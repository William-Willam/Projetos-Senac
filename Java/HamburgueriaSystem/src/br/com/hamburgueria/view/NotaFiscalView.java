package br.com.hamburgueria.view;

import br.com.hamburgueria.model.ItemPedido;
import br.com.hamburgueria.model.Pedido;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.print.*;
import java.net.URLEncoder;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.net.URI;
import java.awt.Desktop;
import java.util.Locale;

public class NotaFiscalView extends JFrame {

    private Pedido pedido;
    private JPanel mainPanel;
    private JButton btnImprimir, btnWhatsApp;

    public NotaFiscalView(Pedido pedido) {
        this.pedido = pedido;
        initComponents();
    }

    private void initComponents() {
        this.setTitle("Nota Fiscal - Pedido #" + pedido.getId());
        this.setSize(600, 500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout(10, 10));

        mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // --- Cabeçalho da Nota ---
        JPanel headerPanel = new JPanel(new GridLayout(4, 1));
        headerPanel.add(new JLabel("<html><h2 style='text-align:center;'>Hamburgueria Deliciosa</h2></html>"));
        headerPanel.add(new JLabel("<html><p style='text-align:center;'>Rua da Delícia, 123 - Centro - Cidade</p></html>"));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        headerPanel.add(new JLabel("Data da Compra: " + sdf.format(new Date())));
        headerPanel.add(new JLabel("Nº da Nota: " + pedido.getId()));

        // --- Dados do Cliente ---
        JPanel clientePanel = new JPanel(new GridLayout(2, 1));
        clientePanel.setBorder(BorderFactory.createTitledBorder("Dados do Cliente"));
        clientePanel.add(new JLabel("Nome: " + pedido.getCliente().getNome()));
        clientePanel.add(new JLabel("CPF: " + pedido.getCliente().getCpf()));

        // --- Tabela de Itens ---
        String[] colunas = {"Produto", "Qtd", "Preço Unitário", "Subtotal"};
        DefaultTableModel tableModel = new DefaultTableModel(colunas, 0);
        JTable tableItens = new JTable(tableModel);

        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        for (ItemPedido item : pedido.getItens()) {
            tableModel.addRow(new Object[]{
                    item.getProduto().getNome(),
                    item.getQuantidade(),
                    currencyFormat.format(item.getPrecoUnitario()),
                    currencyFormat.format(item.getSubtotal())
            });
        }

        tableItens.setPreferredScrollableViewportSize(new Dimension(500, 150));
        JScrollPane scrollPane = new JScrollPane(tableItens);

        // --- Painel do meio com cliente e tabela ---
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.add(clientePanel);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        centerPanel.add(scrollPane);

        // --- Rodapé da Nota ---
        JPanel footerPanel = new JPanel(new BorderLayout());
        footerPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        JLabel lblTotal = new JLabel("Total do Pedido: " + currencyFormat.format(pedido.getTotal()));
        lblTotal.setFont(new Font("Arial", Font.BOLD, 18));
        lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        btnImprimir = new JButton("Imprimir Nota");
        btnWhatsApp = new JButton("Enviar via WhatsApp");
        buttonPanel.add(btnImprimir);
        buttonPanel.add(btnWhatsApp);

        footerPanel.add(lblTotal, BorderLayout.EAST);
        footerPanel.add(buttonPanel, BorderLayout.WEST);

        // --- Monta a interface ---
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(footerPanel, BorderLayout.SOUTH);

        this.add(mainPanel);

        // Listeners
        btnImprimir.addActionListener(e -> imprimirNota());
        btnWhatsApp.addActionListener(e -> enviarParaWhatsApp());
    }

    private void imprimirNota() {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(new CupomFiscalPrintable());

        if (job.printDialog()) {
            try {
                job.print();
            } catch (PrinterException ex) {
                JOptionPane.showMessageDialog(this, "Erro ao imprimir: " + ex.getMessage(), "Erro de Impressão", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class CupomFiscalPrintable implements Printable {
        @Override
        public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) {
            if (pageIndex > 0) {
                return NO_SUCH_PAGE;
            }

            Graphics2D g2d = (Graphics2D) graphics;
            g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

            Font fonteNormal = new Font("Monospaced", Font.PLAIN, 10);
            Font fonteNegrito = new Font("Monospaced", Font.BOLD, 10);
            NumberFormat currency = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

            int y = 0;
            g2d.setFont(fonteNegrito);
            g2d.drawString("HAMBURGUERIA DELICIOSA", 0, y += 15);
            g2d.setFont(fonteNormal);
            g2d.drawString("Rua da Delícia, 123 - Centro - Cidade", 0, y += 15);
            g2d.drawString("CNPJ: 00.000.000/0001-00", 0, y += 15);
            g2d.drawString("-------------------------------------", 0, y += 15);
            g2d.drawString("CUPOM FISCAL", 0, y += 15);
            g2d.drawString("-------------------------------------", 0, y += 15);
            g2d.drawString("PEDIDO #" + pedido.getId(), 0, y += 15);
            g2d.drawString("Data: " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()), 0, y += 15);
            g2d.drawString("-------------------------------------", 0, y += 15);

            g2d.drawString("CLIENTE: " + pedido.getCliente().getNome(), 0, y += 15);
            g2d.drawString("CPF: " + pedido.getCliente().getCpf(), 0, y += 15);
            g2d.drawString("-------------------------------------", 0, y += 15);

            g2d.setFont(fonteNegrito);
            g2d.drawString("PRODUTO                QTD      SUBTOTAL", 0, y += 15);
            g2d.setFont(fonteNormal);
            for (ItemPedido item : pedido.getItens()) {
                String nomeProduto = item.getProduto().getNome();
                if (nomeProduto.length() > 20) {
                    nomeProduto = nomeProduto.substring(0, 17) + "...";
                }
                String linha = String.format("%-20s %3d    %8s",
                        nomeProduto,
                        item.getQuantidade(),
                        currency.format(item.getSubtotal()));
                g2d.drawString(linha, 0, y += 15);
            }

            g2d.drawString("-------------------------------------", 0, y += 15);
            g2d.setFont(fonteNegrito);
            g2d.drawString("TOTAL: " + currency.format(pedido.getTotal()), 0, y += 15);
            g2d.setFont(fonteNormal);
            g2d.drawString("-------------------------------------", 0, y += 15);
            g2d.drawString("Obrigado por sua preferência!", 0, y += 15);

            return PAGE_EXISTS;
        }
    }

    private void enviarParaWhatsApp() {
        String numero = JOptionPane.showInputDialog(this, "Insira o número do cliente (com DDD, ex: 5511999998888):");
        if (numero == null || numero.isEmpty()) return;

        NumberFormat currency = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

        StringBuilder mensagem = new StringBuilder();
        mensagem.append("🍔 *Hamburgueria Deliciosa - Nota Fiscal*\n\n");
        mensagem.append("*Pedido N°:* ").append(pedido.getId()).append("\n");
        mensagem.append("*Cliente:* ").append(pedido.getCliente().getNome()).append("\n");
        mensagem.append("*CPF:* ").append(pedido.getCliente().getCpf()).append("\n\n");
        mensagem.append("*Itens do Pedido:*\n");

        for (ItemPedido item : pedido.getItens()) {
            mensagem.append("- ").append(item.getQuantidade())
                    .append("x ").append(item.getProduto().getNome())
                    .append(" (").append(currency.format(item.getSubtotal())).append(")\n");
        }

        mensagem.append("\n*Total:* ").append(currency.format(pedido.getTotal())).append("\n");
        mensagem.append("\nObrigado por sua preferência!");

        try {
            String urlMensagem = URLEncoder.encode(mensagem.toString(), "UTF-8");
            String url = "https://api.whatsapp.com/send?phone=" + numero.replaceAll("[^0-9]", "") + "&text=" + urlMensagem;
            Desktop.getDesktop().browse(new URI(url));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao tentar abrir o WhatsApp: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
