using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Runtime.Serialization;

namespace EventHubGenerator
{
    [DataContract]
    class CDRecord
    {
        [DataMember]
        public int id { get; set; }

        [DataMember]

        public double temperature { get; set; }

        [DataMember]

        public double humidity { get; set; }

        [DataMember]

        public DateTime createtime { get; set; }

        [DataMember]

        public string msgtype { get; set; }

        [DataMember]

        public byte[] sensorID { get; set; }

        [DataMember]

        public int typeID { get; set; }
    }
}
