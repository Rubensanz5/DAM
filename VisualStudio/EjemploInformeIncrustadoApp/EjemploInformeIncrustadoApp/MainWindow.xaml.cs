using iText.IO.Font.Constants;
using iText.Kernel.Font;
using iText.Kernel.Geom;
using iText.Kernel.Pdf;
using iText.Layout;
using iText.Layout.Element;
using iText.Layout.Properties;
using System;
using System.Windows;

namespace EjemploInformeIncrustadoApp
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void btnGenerar_Click(object sender, RoutedEventArgs e)
        {
            crearPDF();
        }

        private void crearPDF()
        {
            string directorio = Environment.GetFolderPath(Environment.SpecialFolder.MyDocuments);

            string nombreArchivo = DateTime.Now.ToString("yyyyMMdd_HHmmss") +
                "_" + "Informe.pdf";

            string rutaCompleta = System.IO.Path.Combine(directorio, nombreArchivo);

            PdfWriter pdfWriter = new PdfWriter(rutaCompleta);
            PdfDocument pdf = new PdfDocument(pdfWriter);
            Document documento = new Document(pdf, PageSize.LETTER);

            documento.SetMargins(60, 20, 55, 20);

            PdfFont fontColumnas = PdfFontFactory.CreateFont(StandardFonts.HELVETICA_BOLD);
            PdfFont fontContenido = PdfFontFactory.CreateFont(StandardFonts.HELVETICA);

            string[] columnas = { "Código", "Nombre", "Descripción", "Precio", "Existencias", "Categoría" };
            float[] tamanios = { 2, 4, 6, 2, 2, 4 };

            Table tabla = new Table(UnitValue.CreatePercentArray(tamanios));
            tabla.SetWidth(UnitValue.CreatePercentValue(100));

            foreach (string columna in columnas)
            {
                tabla.AddHeaderCell(new Cell().Add(new Paragraph(columna).SetFont(fontColumnas)));
            }

            ProductoCollection lista = new ProductoCollection();
            ControladorProductos ctrlProductos = new ControladorProductos();

            try
            {
                lista = ctrlProductos.consultar(null);
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }

            if (lista != null)
            {
                foreach (Producto producto in lista)
                {
                    tabla.AddCell(new Cell().Add(new Paragraph(producto.Codigo).SetFont(fontContenido)));
                    tabla.AddCell(new Cell().Add(new Paragraph(producto.Nombre).SetFont(fontContenido)));
                    tabla.AddCell(new Cell().Add(new Paragraph(producto.Descripcion).SetFont(fontContenido)));
                    tabla.AddCell(new Cell().Add(new Paragraph(producto.Precio.ToString()).SetFont(fontContenido).SetTextAlignment(iText.Layout.Properties.TextAlignment.RIGHT)));
                    tabla.AddCell(new Cell().Add(new Paragraph(producto.Existencias.ToString()).SetFont(fontContenido).SetTextAlignment(iText.Layout.Properties.TextAlignment.RIGHT)));
                    tabla.AddCell(new Cell().Add(new Paragraph(producto.NombreCategoria).SetFont(fontContenido)));
                }
            }

            documento.Add(tabla);

            documento.Close();

            MessageBox.Show("Informe guardado en: " + rutaCompleta);

        }
    }
}
