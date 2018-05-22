using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Microsoft.ServiceBus;
using Microsoft.ServiceBus.Messaging;
using Newtonsoft.Json;
using System.IO;

namespace EventHubGenerator
{
    class Program
    {
        static void Main(string[] args)
        {
            string connectionString =
                @"<eventhub connection string without EntityPath>";
            NamespaceManager namespaceManager = NamespaceManager.CreateFromConnectionString(connectionString);
            string eventHubName = "lazhueventhub";
            EventHubClient client = EventHubClient.Create(eventHubName);
            int i = 0;
            Random rand = new Random();
            while (true) {
                CDRecord r = new CDRecord();
                r.id = i;
                r.temperature = 20.1;
                r.humidity = 68.6;
                r.createtime = DateTime.Now;
                r.msgtype = "thsensor";
                r.sensorID = new byte[] {0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0xa1, 0x01, 0xd1, 0x17};
                r.typeID = rand.Next() % 4;

                var serializedString = JsonConvert.SerializeObject(r);
                EventData data = new EventData(Encoding.UTF8.GetBytes(serializedString));
                client.Send(data);
                
                Console.WriteLine("Send " + i + " message");
                System.Threading.Thread.Sleep(500);
                i++;
            }

            /*StreamReader sr = new StreamReader(@"C:\cases\117111317142938\request.json");
            string json = sr.ReadToEnd();
            EventData data = new EventData(Encoding.UTF8.GetBytes(json));
            client.Send(data);*/

        }
    }
}
