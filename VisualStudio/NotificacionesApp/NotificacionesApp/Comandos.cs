using System;
using System.Collections.Generic;
using System.Text;
using System.Windows.Input;

namespace NotificacionesApp
{
    public static class Comandos
    {
        public static readonly RoutedUICommand MostrarNotificacion = new RoutedUICommand(
            "Mostrar Notificación",
            "MostrarNotificacion",
            typeof(Comandos),
            new InputGestureCollection()
            {
                new KeyGesture(Key.F5, ModifierKeys.Control)
            }
            );

    }
}
