using iText.IO.Font.Constants;
using iText.IO.Image;
using iText.Kernel.Colors;
using iText.Kernel.Font;
using iText.Kernel.Geom;
using iText.Kernel.Pdf;
using iText.Layout;
using iText.Layout.Element;
using iText.Layout.Properties;
using System;
using System.IO;
using System.Windows;

namespace EjemploInformeIncrustadoConCabeceraYPieApp
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
            string rutaAplicacion = Directory.GetCurrentDirectory();
            string nombreArchivo = "InformeIntermedio.pdf";

            string rutaCompleta = System.IO.Path.Combine(rutaAplicacion, nombreArchivo);

            PdfWriter pdfWriter = new PdfWriter(rutaCompleta);
            PdfDocument pdf = new PdfDocument(pdfWriter);
            //tamaño personalizado
            // 1 pulgada = 72 pt. (8 1/2p X 11p) = (612 pt X 792 pt) <-- LETTER
            PageSize tamanio = new PageSize(612, 792);
            Document documento = new Document(pdf, tamanio);
            //Document documento = new Document(pdf, PageSize.LETTER);

            documento.SetMargins(80, 20, 55, 20);

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

            string directorio = Environment.GetFolderPath(Environment.SpecialFolder.MyDocuments);
            string nombreArchivoNuevo = DateTime.Now.ToString("yyyyMMdd_HHmmss") +
            "_" + "InformeConCabeceraYPie.pdf";
            string rutaCompletaNueva = System.IO.Path.Combine(directorio, nombreArchivoNuevo);

            // Preparar cabecera y pie de página
            var logo = new Image(ImageDataFactory.Create(@"..\..\..\images\imagen.jpg")).SetWidth(50);
            var plogo = new Paragraph("").Add(logo);

            Color miColor = new DeviceRgb(0, 0, 255);
            var titulo = new Paragraph("Informe de productos");
            titulo.SetTextAlignment(iText.Layout.Properties.TextAlignment.CENTER);
            titulo.SetFontColor(miColor);
            titulo.SetBold();
            titulo.SetFontSize(24);

            var dfecha = DateTime.Now.ToString("dd-MM-yyyy");
            var dhora = DateTime.Now.ToString("HH:mm");
            var fecha = new Paragraph("Fecha: "+dfecha+"\nHora: "+dhora);
            fecha.SetFontSize(12);

            PdfDocument pdfDoc = new PdfDocument(new PdfReader(rutaCompleta), new PdfWriter(rutaCompletaNueva));
            Document doc = new Document(pdfDoc);

            int numeros = pdfDoc.GetNumberOfPages();

            for (int i = 1; i <= numeros; i++)
            {
                PdfPage pagina = pdfDoc.GetPage(i);

                float y = (pdfDoc.GetPage(i).GetPageSize().GetTop() - 15);

                //cabecera
                doc.ShowTextAligned(plogo, 45, y, i, iText.Layout.Properties.TextAlignment.CENTER, iText.Layout.Properties.VerticalAlignment.TOP, 0);
                doc.ShowTextAligned(titulo, 300, y - 15, i, iText.Layout.Properties.TextAlignment.CENTER, iText.Layout.Properties.VerticalAlignment.TOP, 0);
                doc.ShowTextAligned(fecha, 590, y - 15, i, iText.Layout.Properties.TextAlignment.RIGHT, iText.Layout.Properties.VerticalAlignment.TOP, 0);

                //pie de página
                doc.ShowTextAligned(new Paragraph(String.Format("Página {0} de {1}", i, numeros)),
                    pdfDoc.GetPage(i).GetPageSize().GetWidth() / 2,
                    pdfDoc.GetPage(i).GetPageSize().GetBottom() + 30, i, iText.Layout.Properties.TextAlignment.CENTER,
                    iText.Layout.Properties.VerticalAlignment.TOP, 0); 
            }

            doc.Close();

            MessageBox.Show("Informe guardado en: " + rutaCompletaNueva);

        }
    }
}
