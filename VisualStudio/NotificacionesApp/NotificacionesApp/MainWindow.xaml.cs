using Microsoft.Toolkit.Uwp.Notifications;
using System;
using System.Windows;
using System.Windows.Shapes;
using System.IO;
using System.Reflection;
using System.Windows.Input;

namespace NotificacionesApp
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();

            // Borra las notificaciones anteriores
            ToastNotificationManagerCompat.History.Clear();
        }

        private void ComprobarMostrarNotificacion(object sender, CanExecuteRoutedEventArgs e)
        {
            e.CanExecute = true;
        }

        private void EjecutarMostrarNotificacion(object sender, ExecutedRoutedEventArgs e)
        {
            var outPutDirectory = System.IO.Path.GetDirectoryName(Assembly.GetExecutingAssembly().CodeBase);
            var imagePath = System.IO.Path.Combine(outPutDirectory, @"..\..\..\images\image-364x180.jpg");
            string imageUri = new Uri(imagePath).LocalPath;

            var iconPath = System.IO.Path.Combine(outPutDirectory, @"..\..\..\images\icono.jpg");
            string iconUri = new Uri(iconPath).LocalPath;

            new ToastContentBuilder()
                .AddText("Título de la Notificación")
                .AddText("Descripción de la Notificación")

                // Text box for replying
                .AddInputTextBox("tbReply", placeHolderContent: "Escribir una respuesta")

                // Buttons
                .AddButton(new ToastButton()
                    .SetContent("Enviar respuesta")
                    .AddArgument("action", "reply")
                    .SetBackgroundActivation())

                    .AddToastInput(new ToastSelectionBox("time")
                    {
                        DefaultSelectionBoxItemId = "almuerzo",
                        Items =
                            {
                                new ToastSelectionBoxItem("desayuno", "Desayuno"),
                                new ToastSelectionBoxItem("almuerzo", "Almuerzo"),
                                new ToastSelectionBoxItem("cena", "Cena")
                            }
                    })

                .AddAppLogoOverride(new Uri(iconUri), ToastGenericAppLogoCrop.Circle)
                .AddHeroImage(new Uri(imageUri))

                .AddAttributionText("Via SMS")

                .Show();
        }
    }
}
