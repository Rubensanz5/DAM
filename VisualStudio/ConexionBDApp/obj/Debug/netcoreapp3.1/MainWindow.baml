   M S B A M L   `   `   `  ����H  DConexionBDApp, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null-clr-namespace:ConexionBDAppConexionBDApp  5   	       ConexionBDApp.MainWindow   5   	   W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35e aSystem.Windows.Controls.Ribbon, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35F 9http://schemas.microsoft.com/winfx/2006/xaml/presentation     5   	   R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   -localclr-namespace:ConexionBDApp     5   	     � Title$  Conexión a MySQL��5   	   $	��450��6"   $	��600��6/   .��5	      � .+�5
   
   �� $��	Servidor:��6   $
��Left=�6$   $��
204,32,0,0q�6?   $	��Top=�6S   $��20(�6k   �� 5   
   -   5         ��Name$ txtServidor��5      $
��Left=�6'   $��
317,32,0,0q�6B    �� TextWrapping$
 Wrap=�6V   $	��Top=�5      $	��135��6*   $��38��66   $��20(�6B   �� 5   
   $��Puerto:��6   $
��Left=�6"   $��
218,86,0,0q�6=   $	��Top=�6Q   $��20(�6i   �� 5   
   -   5        $ 	txtPuerto��5      $
��Left=�6%   $��
317,86,0,0q�6@   $
 Wrap=�6T   $	��Top=�5      $	��135��6*   $��38��66   $��20(�6B   �� 5   
   $��Base de Datos:��6   $
��Left=�6)   $��152,142,0,0q�6D   $	��Top=�6Y   $��20(�6q   �� 5   
   -   5        $ txtBD��5      $
��Left=�6!   $��317,142,0,0q�6<   $
 Wrap=�6Q   $	��Top=�5      $	��135��6*   $��38��66   $��20(�6B   �� 5   
   $��Usuario:��6   $
��Left=�6#   $��210,200,0,0q�6>   $	��Top=�6S   $��20(�6k   �� 5   
   -   5        $ 
txtUsuario��5      $
��Left=�6&   $��317,200,0,0q�6A   $
 Wrap=�6V   $	��Top=�5      $	��135��6*   $��38��66   $��20(�6B   �� 5   
   $��Contraseña:��6   $
��Left=�6&   $��177,264,0,0q�6A   $	��Top=�6V   $��20(�6n   G� 5   
   -   5         G�Name$ pwdPassword��5      $
��Left=�6+   $��317,263,0,0q�6F   $	��Top=�5      $	��135��6.   $��20(�6:   $��38��6H   �� 5   
   -   5         ��Name$ btnConectar��5      $��Conectar a BD��6&   $
��Left=�6>   $��204,354,0,0q�6Y   $	��Top=�5      $��20(�6)   $	��209��67   6C   5      5      