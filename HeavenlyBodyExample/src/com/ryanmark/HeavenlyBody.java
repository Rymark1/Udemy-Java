package com.ryanmark;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

    public abstract class HeavenlyBody {

        private final Key key;
        private double orbitalPeriod;
        private Set<HeavenlyBody> satellites;

        public enum BodyTypes {
            PLANET,
            DWARF_PLANET,
            MOON
        }

        public HeavenlyBody(String name, double orbitalPeriod, BodyTypes bodyType) {
            this.key = new Key(name, bodyType);
            this.orbitalPeriod = orbitalPeriod;
            this.satellites = new HashSet<>();
        }

        public double getOrbitalPeriod() {
            return this.orbitalPeriod;
        }

        public Key getKey() {
            return this.key;
        }

        public boolean addSatellite(HeavenlyBody heavenlyBody){
            if (this.satellites.add(heavenlyBody))
                return true;
            else
                return false;
        }

        public HashSet<HeavenlyBody> getSatellites(){
            return new HashSet<>(satellites);
        }

        @Override
        public final boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            HeavenlyBody that = (HeavenlyBody) o;
            return Objects.equals(key, that.key);
        }

        @Override
        public int hashCode() {
            return key.hashCode();
        }

        public static Key makeKey(String name, BodyTypes bodyType){
            return new Key(name, bodyType);
        }

        public String toString(){
            return getKey().getName() + ": " + getKey().getBodyType() + ", " + this.getOrbitalPeriod();
        }

        public static final class Key{
            private String name;
            private BodyTypes bodyType;

            private Key(String name, BodyTypes bodytype) {
                this.name = name;
                this.bodyType = bodytype;
            }

            public String getName() {
                return name;
            }

            public BodyTypes getBodyType() {
                return this.bodyType;
            }

            @Override
            public boolean equals(Object o) {
                Key key = (Key) o;
                return Objects.equals(this.name, key.name) && this.bodyType == key.bodyType;
            }

            @Override
            public int hashCode() {
                return this.name.hashCode() + this.bodyType.hashCode() + 5;
            }

            @Override
            public String toString() {
                return this.name + ": " + this.bodyType;
            }
        }
    }